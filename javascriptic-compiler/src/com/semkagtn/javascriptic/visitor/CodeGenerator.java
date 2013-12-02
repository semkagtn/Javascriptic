package com.semkagtn.javascriptic.visitor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.semkagtn.javascriptic.tree.AddNode;
import com.semkagtn.javascriptic.tree.AndNode;
import com.semkagtn.javascriptic.tree.ArrayNode;
import com.semkagtn.javascriptic.tree.AssignmentNode;
import com.semkagtn.javascriptic.tree.BlockNode;
import com.semkagtn.javascriptic.tree.BoolNode;
import com.semkagtn.javascriptic.tree.DivNode;
import com.semkagtn.javascriptic.tree.EqNode;
import com.semkagtn.javascriptic.tree.ExpressionNode;
import com.semkagtn.javascriptic.tree.ExpressionStatementNode;
import com.semkagtn.javascriptic.tree.FunctionCallNode;
import com.semkagtn.javascriptic.tree.FunctionNode;
import com.semkagtn.javascriptic.tree.FunctionParameterNode;
import com.semkagtn.javascriptic.tree.GeNode;
import com.semkagtn.javascriptic.tree.GetIndexNode;
import com.semkagtn.javascriptic.tree.GtNode;
import com.semkagtn.javascriptic.tree.IfElseNode;
import com.semkagtn.javascriptic.tree.LeNode;
import com.semkagtn.javascriptic.tree.LtNode;
import com.semkagtn.javascriptic.tree.ModNode;
import com.semkagtn.javascriptic.tree.MulNode;
import com.semkagtn.javascriptic.tree.NeNode;
import com.semkagtn.javascriptic.tree.NegNode;
import com.semkagtn.javascriptic.tree.NotNode;
import com.semkagtn.javascriptic.tree.NumberNode;
import com.semkagtn.javascriptic.tree.OrNode;
import com.semkagtn.javascriptic.tree.ProgramNode;
import com.semkagtn.javascriptic.tree.PutIndexNode;
import com.semkagtn.javascriptic.tree.ReturnNode;
import com.semkagtn.javascriptic.tree.StatementNode;
import com.semkagtn.javascriptic.tree.StringNode;
import com.semkagtn.javascriptic.tree.SubNode;
import com.semkagtn.javascriptic.tree.UndefNode;
import com.semkagtn.javascriptic.tree.VarNode;
import com.semkagtn.javascriptic.tree.WhileNode;

public class CodeGenerator implements AstVisitor<Object>, Opcodes {
	// Constants
	private static final String RUNTIME_PACKAGE = "com/semkagtn/javascriptic/runtime/";
	
	private class Class {
		public static final String OBJECT = RUNTIME_PACKAGE + "JSObject";
		public static final String BOOL = RUNTIME_PACKAGE + "JSBool";
		public static final String UNDEF = RUNTIME_PACKAGE + "JSUndef";
		public static final String STRING = RUNTIME_PACKAGE + "JSString";
		public static final String NUMBER = RUNTIME_PACKAGE + "JSNumber";
		public static final String FUNCTION = RUNTIME_PACKAGE + "JSFunction";
		public static final String ARRAY = RUNTIME_PACKAGE + "JSArray";
	}
	
	private class Type {
		public static final String OBJECT = "L" + Class.OBJECT + ';';
		public static final String BOOL = "L" + Class.BOOL + ';';
		public static final String UNDEF = "L" + Class.UNDEF + ';';
		//public static final String STRING = "L" + Class.STRING + ';';
		//public static final String NUMBER = "L" + Class.NUMBER + ';';
		public static final String FUNCTION = "L" + Class.FUNCTION + ';';
		//public static final String ARRAY = "L" + Class.ARRAY + ";";
	}
	
	public static final String CALL_SIGNATURE = "([" + Type.OBJECT + ")" +  Type.OBJECT;
	public static final String BINARY_SIGNATURE  = "(" + Type.OBJECT + ")" + Type.OBJECT;
	public static final String UNARY_SIGNATURE  = "()" + Type.OBJECT;
	public static final String ARRAY_SIGNATURE = "([" + Type.OBJECT + ")V";
	public static final String PUT_SIGNATURE = "(" + Type.OBJECT +  Type.OBJECT + ")" + Type.OBJECT;
	
	// Fields
	private String fileName;
	private boolean mainScope;
	private int functionCounter;
	private final LinkedList<FunctionWriter> writers;
	
	// Constructor
	public CodeGenerator(String fileName) {
		this.fileName = fileName;
		mainScope = true;
		functionCounter = 0;
		writers = new LinkedList<>();
	}
	
	// FunctionWriter
	private class FunctionWriter {
		private ClassWriter cw;
		private MethodVisitor mv;
		private FunctionNode function;
		private int number;
		private String signature;
		private int currentStack;
		private int maxStack;
		
		public FunctionWriter(FunctionNode function) {
			this.cw = new ClassWriter(0);
			this.function = function;
			this.number = functionCounter;
			StringBuilder signature = new StringBuilder("(");
			for (FunctionWriter fw : writers) {
				signature.append(scopeType(fw.getNumber()));
			}
			signature.append(")V");
			this.signature = signature.toString();
			this.currentStack = 1;
			this.maxStack = 2;
			++functionCounter;
		}
		
		public FunctionNode getFunction() {
			return function;
		}
		
		public String getSignature() {
			return signature;
		}
		
		public int getNumber() {
			return number;
		}
		
		// Use this method after visitMethodInsn
		public void stackPop(int times) {
			currentStack -= times;
		}
		
		public void visitTryCatchBlock(Label tryStart, Label tryEnd,
				Label catchStart, String exception) {
			mv.visitTryCatchBlock(tryStart, tryEnd, catchStart, exception);
		}
		
		public void visitFieldInsn(int opcode, String owner, String name, String desc) {
			if (opcode == GETSTATIC) {
				++currentStack;
				maxStack = Math.max(maxStack, currentStack);
			} else if (opcode == PUTFIELD) {
				currentStack -= 2;
			} else if (opcode != GETFIELD) {
				System.err.println("Unknown opcode visitFieldInsn");
				System.exit(1);
			}
			mv.visitFieldInsn(opcode, owner, name, desc);
		}
		
		public void visitInsn(int opcode) {
			if (opcode == DUP) {
				++currentStack;
				maxStack = Math.max(maxStack, currentStack);
			} else if (opcode == AALOAD || opcode == AASTORE || opcode == POP) {
				--currentStack;
			} else if (opcode != RETURN && opcode != ARETURN) {
				System.err.println("Unknown opcode visitInsn");
				System.exit(1);
			}
			mv.visitInsn(opcode);
		}
		
		public void visitJumpInsn(int opcode, Label label) {
			mv.visitJumpInsn(opcode, label);
		}
		
		public void visitLabel(Label label) {
			mv.visitLabel(label);
		}
		
		public void visitLdcInsn(Object cst) {
			++currentStack;
			maxStack = Math.max(maxStack, currentStack);
			mv.visitLdcInsn(cst);
		}
		
		public void visitMethodInsn(int opcode, String owner, String name, String desc) {
			mv.visitMethodInsn(opcode, owner, name, desc);
		}
		
		public void visitTypeInsn(int opcode, String type) {
			++currentStack;
			maxStack = Math.max(maxStack, currentStack);
			mv.visitTypeInsn(opcode, type);
		}
		
		public void visitVarInsn(int opcode, int var) {
			if (opcode == ALOAD) {
				++currentStack;
				maxStack = Math.max(maxStack, currentStack);
			} else if (opcode == ASTORE) {
				--currentStack;
			} else {
				System.err.println("Unknown opcode visitVarInsn");
				System.exit(1);
			}
			mv.visitVarInsn(opcode, var);
		}
		
		public void handleFunction() {
			generateScopeClass();
			cw = new ClassWriter(0);
			cw.visit(V1_1, ACC_PUBLIC, functionClass(number), null, Class.FUNCTION, null);
			for (FunctionWriter fw : writers) {
				cw.visitField(ACC_PUBLIC, scopeName(fw.getNumber()),
						scopeType(fw.getNumber()), null, null);
			}
			
			// Constructor
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", getSignature(), null, null);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitLdcInsn(function.getValue());
			mv.visitMethodInsn(INVOKESPECIAL, Class.FUNCTION,
					"<init>", "(Ljava/lang/String;)V");
			int i = 1;
			for (FunctionWriter fw : writers) {
				if (!functionClass(fw.getNumber()).equals(functionClass(number))) {
					mv.visitVarInsn(ALOAD, 0);
					mv.visitVarInsn(ALOAD, i);
					++i;
					mv.visitFieldInsn(PUTFIELD, functionClass(number),
							scopeName(fw.getNumber()), scopeType(fw.getNumber()));
				}
			}
			mv.visitInsn(RETURN);
			mv.visitMaxs(2, writers.size());
			mv.visitEnd();
			
			// call
			mv = cw.visitMethod(ACC_PUBLIC, "call", CALL_SIGNATURE, null, null);
			visitVarInsn(ALOAD, 0);
			visitTypeInsn(NEW, scopeClass(number));
			visitInsn(DUP);
			visitMethodInsn(INVOKESPECIAL, scopeClass(number), "<init>", "()V");
			stackPop(1);
			visitFieldInsn(PUTFIELD, functionClass(number),
					scopeName(number), scopeType(number));
			
			if (function.getParameters().size() > 0) {
				Label tryStart = new Label();
				Label tryEnd = new Label();
				Label catchStart = new Label();
				Label catchEnd = new Label();
				visitTryCatchBlock(tryStart, tryEnd, catchStart, "java/lang/Exception");
				visitLabel(tryStart);
				i = 0;
				for (FunctionParameterNode param : function.getParameters()) {
					visitVarInsn(ALOAD, 0);
					visitFieldInsn(GETFIELD, functionClass(number),
							scopeName(number), scopeType(number));
					visitVarInsn(ALOAD, 1);
					visitLdcInsn(i);
					++i;
					visitInsn(AALOAD);
					visitFieldInsn(PUTFIELD, scopeClass(number), param.getName(), Type.OBJECT);
				}
				visitLabel(tryEnd);
				visitJumpInsn(GOTO, catchEnd);
				visitLabel(catchStart);
				visitVarInsn(ASTORE, 1);
				visitLabel(catchEnd);
			}
			
			for (StatementNode stat : this.getFunction().getBody()) {
				stat.accept(CodeGenerator.this);
			}
			visitFieldInsn(GETSTATIC, Class.UNDEF, "UNDEF", Type.UNDEF);
			visitInsn(ARETURN);
			mv.visitMaxs(maxStack, 2);
			mv.visitEnd();
					
			cw.visitEnd();
			
			writeFile(cw, functionClass(number));
		}
		
		private void generateScopeClass() {
			ClassWriter cw = new ClassWriter(0);
			cw.visit(V1_1, ACC_PUBLIC, scopeClass(number), null, "java/lang/Object", null);
			
			if (mainScope) {
				for (String f : LIBRARY) {
					function.getVariables().add(f);
				}
			}
			
			for (String var : function.getVariables()) {
				cw.visitField(ACC_PUBLIC, var, Type.OBJECT, null, null);
			}
			
			MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
			for (String var : function.getVariables()) {
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, Class.UNDEF, "UNDEF", Type.UNDEF);
				mv.visitFieldInsn(PUTFIELD, scopeClass(number), var, Type.OBJECT);
			}
			
			// Initializing library functions
			if (mainScope) {
				mainScope = false;
				
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, Class.FUNCTION, "PRINT", Type.FUNCTION);
				mv.visitFieldInsn(PUTFIELD, scopeClass(number), PRINT_FUNCTION, Type.OBJECT);
				
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, Class.FUNCTION, "READ", Type.FUNCTION);
				mv.visitFieldInsn(PUTFIELD, scopeClass(number), READ_FUNCTION, Type.OBJECT);
				
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, Class.FUNCTION, "ROUND", Type.FUNCTION);
				mv.visitFieldInsn(PUTFIELD, scopeClass(number), ROUND_FUNCTION, Type.OBJECT);
				
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, Class.FUNCTION, "LENGTH", Type.FUNCTION);
				mv.visitFieldInsn(PUTFIELD, scopeClass(number), LENGTH_FUNCTION, Type.OBJECT);
				
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, Class.FUNCTION, "RANDOM", Type.FUNCTION);
				mv.visitFieldInsn(PUTFIELD, scopeClass(number), RANDOM_FUNCTION, Type.OBJECT);
			}
			
			mv.visitInsn(RETURN);
			mv.visitMaxs(2, 1);
			mv.visitEnd();
			
			cw.visitEnd();
			
			writeFile(cw, scopeClass(number));
		}
		
	}
	
	// Private methods
	private String functionClass(int number) {
		return fileName + "$Function" + number;
	}
	
	private String scopeClass(int number) {
		return fileName + "$Scope" + number;
	}
	
	private String scopeType(int number) {
		return "L" + scopeClass(number) + ";";
	}
	
	private String scopeName(int number) {
		return "scope" + number;
	}
	
	private void writeFile(ClassWriter cw, String className) {
		try {
			byte[] code = cw.toByteArray();
			FileOutputStream fos = new FileOutputStream(className + ".class");
			fos.write(code);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int findScopeNumber(VarNode var) {
		for (FunctionWriter fw : writers) {
			for (String v : fw.getFunction().getVariables()) {
				if (v.equals(var.getName())) {
					return fw.getNumber();
				}
			}
		}
		return -1;
	}
	
	// Public methods
	public Object visit(AddNode add) {
		add.getLhs().accept(this);
		add.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "add", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(AndNode and) {
		and.getLhs().accept(this);
		and.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "and", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(AssignmentNode assign) {
		int number = findScopeNumber(assign.getVariable());
		FunctionWriter w = writers.peek();
		
		w.visitVarInsn(ALOAD, 0);
		w.visitFieldInsn(GETFIELD, functionClass(w.getNumber()),
				scopeName(number), scopeType(number));
		assign.getExpression().accept(this);
		w.visitFieldInsn(PUTFIELD, scopeClass(number),
				assign.getVariable().getName(), Type.OBJECT);
		
		w.visitVarInsn(ALOAD, 0);
		w.visitFieldInsn(GETFIELD, functionClass(w.getNumber()),
				scopeName(number), scopeType(number));
		w.visitFieldInsn(GETFIELD, scopeClass(number),
				assign.getVariable().getName(), Type.OBJECT);
		return null;
	}

	public Object visit(BlockNode block) {
		for (StatementNode stat: block.getBody()) {
			stat.accept(this);
		}
		return null;
	}


	public Object visit(BoolNode bool) {
		writers.peek().visitFieldInsn(GETSTATIC, Class.BOOL,
				bool.getValue().toUpperCase(), Type.BOOL);
		return null;
	}

	public Object visit(DivNode div) {
		div.getLhs().accept(this);
		div.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "div", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(EqNode eq) {
		eq.getLhs().accept(this);
		eq.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "eq", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(ExpressionStatementNode exprStat) {
		exprStat.getExpression().accept(this);
		writers.peek().visitInsn(POP);
		return null;
	}

	public Object visit(FunctionCallNode functionCall) {
		functionCall.getFunction().accept(this);
		writers.peek().visitLdcInsn(functionCall.getArguments().size());
		writers.peek().visitTypeInsn(ANEWARRAY, Class.OBJECT);
		int i = 0;
		for (ExpressionNode arg : functionCall.getArguments()) {
			writers.peek().visitInsn(DUP);
			writers.peek().visitLdcInsn(i);
			++i;
			arg.accept(this);
			writers.peek().visitInsn(AASTORE);
		}
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "call", CALL_SIGNATURE);
		writers.peek().stackPop(functionCall.getArguments().size());
		return null;
	}

	public Object visit(FunctionNode function) {
		FunctionWriter fw = new FunctionWriter(function);
		writers.push(fw);
		writers.peek().handleFunction();
		writers.pop();
		FunctionWriter w = writers.peek();
		w.visitTypeInsn(NEW, functionClass(fw.getNumber()));
		w.visitInsn(DUP);
		for (FunctionWriter writer : writers) {
			w.visitVarInsn(ALOAD, 0);
			w.visitFieldInsn(GETFIELD, functionClass(w.getNumber()),
					scopeName(writer.getNumber()), scopeType(writer.getNumber()));
		}
		w.visitMethodInsn(INVOKESPECIAL,
				functionClass(fw.getNumber()), "<init>", fw.getSignature());
		writers.peek().stackPop(writers.size() + 1);
		return null;
	}

	public Object visit(FunctionParameterNode functionParam) {
		return null;
	}
	
	public Object visit(GeNode ge) {
		ge.getLhs().accept(this);
		ge.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "ge", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(GtNode gt) {
		gt.getLhs().accept(this);
		gt.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "gt", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(IfElseNode ifElse) {
		Label elseBlock = new Label();
		Label end = new Label();
		ifElse.getCondition().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "toInt", "()I"); // 0(false) or 1(true)
		writers.peek().stackPop(0);
		writers.peek().visitJumpInsn(IFEQ, elseBlock); // if x == 0
		ifElse.getIfStatement().accept(this);
		writers.peek().visitJumpInsn(GOTO, end);
		writers.peek().visitLabel(elseBlock);
		if (ifElse.getElseStatement() != null) {
			ifElse.getElseStatement().accept(this);
		}
		writers.peek().visitLabel(end);
		return null;
	}

	public Object visit(LeNode le) {
		le.getLhs().accept(this);
		le.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "le", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(LtNode lt) {
		lt.getLhs().accept(this);
		lt.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "lt", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(ModNode mod) {
		mod.getLhs().accept(this);
		mod.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "mod", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(MulNode mul) {
		mul.getLhs().accept(this);
		mul.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "mul", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(NegNode neg) {
		neg.getExpression().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "neg", UNARY_SIGNATURE);
		writers.peek().stackPop(0);
		return null;
	}

	public Object visit(NeNode ne) {
		ne.getLhs().accept(this);
		ne.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "ne", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(NotNode not) {
		not.getExpression().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "not", UNARY_SIGNATURE);
		writers.peek().stackPop(0);
		return null;
	}

	public Object visit(NumberNode number) {
		writers.peek().visitTypeInsn(NEW, Class.NUMBER);
		writers.peek().visitInsn(DUP);
		writers.peek().visitLdcInsn(number.getValue());
		writers.peek().visitMethodInsn(INVOKESPECIAL,
				Class.NUMBER, "<init>", "(Ljava/lang/String;)V");
		writers.peek().stackPop(2);
		return null;
	}

	public Object visit(OrNode or) {
		or.getLhs().accept(this);
		or.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "or", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(ProgramNode program) {
		ClassWriter cw = new ClassWriter(0);
		cw.visit(V1_1, ACC_PUBLIC, fileName, null, "java/lang/Object", null);
		
		// Constructor
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		// initialization
		mv.visitInsn(RETURN);
		mv.visitMaxs(1, 1);
		mv.visitEnd();
		
		// main
		mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", 
				"([Ljava/lang/String;)V", null, null);
		
		FunctionWriter fw = new FunctionWriter(program);
		writers.push(fw);
		writers.peek().handleFunction();
		writers.pop();
		
		mv.visitTypeInsn(NEW, functionClass(fw.getNumber()));
		mv.visitInsn(DUP);
		mv.visitMethodInsn(INVOKESPECIAL,
				functionClass(fw.getNumber()), "<init>", fw.getSignature());
		mv.visitLdcInsn(0);
		mv.visitTypeInsn(ANEWARRAY, Class.OBJECT);
		mv.visitMethodInsn(INVOKEVIRTUAL,
				functionClass(fw.getNumber()), "call", CALL_SIGNATURE);
		mv.visitInsn(POP);
		
		mv.visitInsn(RETURN);
		mv.visitMaxs(2, 1);
		mv.visitEnd();
		
		writeFile(cw, fileName);
		return null;
	}

	public Object visit(ReturnNode returnStat) {
		if (returnStat.getValue() != null) {
			returnStat.getValue().accept(this);
		} else {
			writers.peek().visitFieldInsn(
					GETSTATIC, Type.UNDEF, "UNDEF", Type.UNDEF);
		}
		writers.peek().visitInsn(ARETURN);
		return null;
	}

	public Object visit(StringNode string) {
		writers.peek().visitTypeInsn(NEW, Class.STRING);
		writers.peek().visitInsn(DUP);
		writers.peek().visitLdcInsn(string.getValue());
		writers.peek().visitMethodInsn(INVOKESPECIAL,
				Class.STRING, "<init>", "(Ljava/lang/String;)V");
		writers.peek().stackPop(2);
		return null;
	}

	public Object visit(SubNode sub) {
		sub.getLhs().accept(this);
		sub.getRhs().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "sub", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(UndefNode undef) {
		writers.peek().visitFieldInsn(
				GETSTATIC, Class.UNDEF, "UNDEF", Type.UNDEF);
		return null;
	}

	public Object visit(VarNode var) {
		int number = findScopeNumber(var);
		FunctionWriter w = writers.peek();
		w.visitVarInsn(ALOAD, 0);
		w.visitFieldInsn(GETFIELD,functionClass(w.getNumber()),
				scopeName(number), scopeType(number));
		w.visitFieldInsn(GETFIELD, scopeClass(number), var.getName(), Type.OBJECT);
		return null;
	}

	public Object visit(WhileNode whileStat) {
		Label loopStart = new Label();
		Label loopEnd = new Label();
		writers.peek().visitLabel(loopStart);
		whileStat.getCondition().accept(this);
		writers.peek().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "toInt", "()I"); // 0(false) or 1(true)
		writers.peek().stackPop(0);
		writers.peek().visitJumpInsn(IFEQ, loopEnd); // if x == false
		whileStat.getStatement().accept(this);
		writers.peek().visitJumpInsn(GOTO, loopStart);
		writers.peek().visitLabel(loopEnd);
		return null;
	}

	public Object visit(ArrayNode array) {
		writers.peek().visitTypeInsn(NEW, Class.ARRAY);
		writers.peek().visitInsn(DUP);
		writers.peek().visitLdcInsn(array.getElements().size());
		writers.peek().visitTypeInsn(ANEWARRAY, Class.OBJECT);
		int i = 0;
		for (ExpressionNode elem : array.getElements()) {
			writers.peek().visitInsn(DUP);
			writers.peek().visitLdcInsn(i);
			++i;
			elem.accept(this);
			writers.peek().visitInsn(AASTORE);
		}
		writers.peek().visitMethodInsn(
				INVOKESPECIAL, Class.ARRAY, "<init>", ARRAY_SIGNATURE);
		writers.peek().stackPop(array.getElements().size() + 1);
		return null;
	}

	public Object visit(GetIndexNode getIndex) {
		getIndex.getVariable().accept(this);
		getIndex.getIndex().accept(this);
		writers.peek().visitMethodInsn(INVOKEVIRTUAL, Class.OBJECT, "get", BINARY_SIGNATURE);
		writers.peek().stackPop(1);
		return null;
	}

	public Object visit(PutIndexNode putIndex) {
		FunctionWriter w = writers.peek();
		putIndex.getVariable().accept(this);
		putIndex.getIndex().accept(this);
		putIndex.getExpression().accept(this);
		w.visitMethodInsn(INVOKEVIRTUAL, Class.OBJECT, "put", PUT_SIGNATURE);
		w.stackPop(2);
		return null;
	}

}

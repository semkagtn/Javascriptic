package com.semkagtn.visitor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.semkagtn.tree.AddNode;
import com.semkagtn.tree.AndNode;
import com.semkagtn.tree.AssignmentNode;
import com.semkagtn.tree.BlockNode;
import com.semkagtn.tree.BoolNode;
import com.semkagtn.tree.DivNode;
import com.semkagtn.tree.EqNode;
import com.semkagtn.tree.ExpressionNode;
import com.semkagtn.tree.ExpressionStatementNode;
import com.semkagtn.tree.FunctionCallNode;
import com.semkagtn.tree.FunctionNode;
import com.semkagtn.tree.FunctionParameterNode;
import com.semkagtn.tree.GeNode;
import com.semkagtn.tree.GtNode;
import com.semkagtn.tree.IfElseNode;
import com.semkagtn.tree.LeNode;
import com.semkagtn.tree.LtNode;
import com.semkagtn.tree.ModNode;
import com.semkagtn.tree.MulNode;
import com.semkagtn.tree.NeNode;
import com.semkagtn.tree.NegNode;
import com.semkagtn.tree.NotNode;
import com.semkagtn.tree.NumberNode;
import com.semkagtn.tree.OrNode;
import com.semkagtn.tree.ProgramNode;
import com.semkagtn.tree.ReturnNode;
import com.semkagtn.tree.StatementNode;
import com.semkagtn.tree.StringNode;
import com.semkagtn.tree.SubNode;
import com.semkagtn.tree.UndefNode;
import com.semkagtn.tree.VarNode;
import com.semkagtn.tree.WhileNode;

public class CodeGenerator implements AstVisitor<Object>, Opcodes {
	// Constants
	private static final String RUNTIME_PACKAGE = "com/semkagtn/runtime/";
	
	private class Class {
		public static final String OBJECT = RUNTIME_PACKAGE + "JSObject";
		public static final String BOOL = RUNTIME_PACKAGE + "JSBool";
		public static final String UNDEF = RUNTIME_PACKAGE + "JSUndef";
		public static final String STRING = RUNTIME_PACKAGE + "JSString";
		public static final String NUMBER = RUNTIME_PACKAGE + "JSNumber";
		public static final String FUNCTION = RUNTIME_PACKAGE + "JSFunction";
	}
	
	private class Type {
		public static final String OBJECT = "L" + Class.OBJECT + ';';
		public static final String BOOL = "L" + Class.BOOL + ';';
		public static final String UNDEF = "L" + Class.UNDEF + ';';
		//public static final String STRING = "L" + Class.STRING + ';';
		//public static final String NUMBER = "L" + Class.NUMBER + ';';
		public static final String FUNCTION = "L" + Class.FUNCTION + ';';
	}
	
	public static final String CALL_SIGNATURE = "([" + Type.OBJECT + ")" +  Type.OBJECT;
	public static final String BINARY_SIGNATURE  = "(" + Type.OBJECT + ")" + Type.OBJECT;
	public static final String UNARY_SIGNATURE  = "()" + Type.OBJECT;
	
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
		
		public FunctionWriter(FunctionNode function) {
			this.cw = new ClassWriter(0);
			this.function = function;
			this.number = functionCounter;
			this.signature = "(";
			for (FunctionWriter fw : writers) {
				this.signature += scopeType(fw.getNumber());
			}
			this.signature += ")V";
			++functionCounter;
		}
		
		public MethodVisitor get() {
			return mv;
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
		
		public void visit() {
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
			mv.visitMaxs(10, 10); // ??
			mv.visitEnd();
			
			// call
			mv = cw.visitMethod(ACC_PUBLIC, "call", CALL_SIGNATURE, null, null);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitTypeInsn(NEW, scopeClass(number));
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, scopeClass(number), "<init>", "()V");
			mv.visitFieldInsn(PUTFIELD, functionClass(number),
					scopeName(number), scopeType(number));
			
			if (function.getParameters().size() > 0) {
				Label tryStart = new Label();
				Label tryEnd = new Label();
				Label catchStart = new Label();
				Label catchEnd = new Label();
				mv.visitTryCatchBlock(tryStart, tryEnd, catchStart, "java/lang/Exception");
				mv.visitLabel(tryStart);
				i = 0;
				for (FunctionParameterNode param : function.getParameters()) {
					mv.visitVarInsn(ALOAD, 0);
					mv.visitFieldInsn(GETFIELD, functionClass(number),
							scopeName(number), scopeType(number));
					mv.visitVarInsn(ALOAD, 1);
					mv.visitLdcInsn(i);
					++i;
					mv.visitInsn(AALOAD);
					mv.visitFieldInsn(PUTFIELD, scopeClass(number), param.getName(), Type.OBJECT);
				}
				mv.visitLabel(tryEnd);
				mv.visitJumpInsn(GOTO, catchEnd);
				mv.visitLabel(catchStart);
				mv.visitVarInsn(ASTORE, 1);
				mv.visitLabel(catchEnd);
			}
			
			for (StatementNode stat : this.getFunction().getBody()) {
				stat.accept(CodeGenerator.this);
			}
			mv.visitFieldInsn(GETSTATIC, Class.UNDEF, "UNDEF", Type.UNDEF);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(20, 20);
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
			}
			
			mv.visitInsn(RETURN);
			mv.visitMaxs(2, 2);
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
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "add", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(AndNode and) {
		and.getLhs().accept(this);
		and.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "and", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(AssignmentNode assign) {
		int number = findScopeNumber(assign.getVariable());
		FunctionWriter w = writers.peek();
		
		w.get().visitVarInsn(ALOAD, 0);
		w.get().visitFieldInsn(GETFIELD, functionClass(w.getNumber()),
				scopeName(number), scopeType(number));
		assign.getExpression().accept(this);
		w.get().visitFieldInsn(PUTFIELD, scopeClass(number),
				assign.getVariable().getName(), Type.OBJECT);
		
		w.get().visitVarInsn(ALOAD, 0);
		w.get().visitFieldInsn(GETFIELD, functionClass(w.getNumber()),
				scopeName(number), scopeType(number));
		w.get().visitFieldInsn(GETFIELD, scopeClass(number),
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
		writers.peek().get().visitFieldInsn(GETSTATIC, Class.BOOL,
				bool.getValue().toUpperCase(), Type.BOOL);
		return null;
	}

	public Object visit(DivNode div) {
		div.getLhs().accept(this);
		div.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "div", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(EqNode eq) {
		eq.getLhs().accept(this);
		eq.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "eq", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(ExpressionStatementNode exprStat) {
		exprStat.getExpression().accept(this);
		writers.peek().get().visitInsn(POP);
		return null;
	}

	public Object visit(FunctionCallNode functionCall) {
		functionCall.getFunction().accept(this);
		writers.peek().get().visitLdcInsn(functionCall.getArguments().size());
		writers.peek().get().visitTypeInsn(ANEWARRAY, Class.OBJECT);
		int i = 0;
		for (ExpressionNode arg : functionCall.getArguments()) {
			writers.peek().get().visitInsn(DUP);
			writers.peek().get().visitLdcInsn(i);
			++i;
			arg.accept(this);
			writers.peek().get().visitInsn(AASTORE);
		}
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "call", CALL_SIGNATURE);
		return null;
	}

	public Object visit(FunctionNode function) {
		FunctionWriter fw = new FunctionWriter(function);
		writers.push(fw);
		writers.peek().visit();
		writers.pop();
		FunctionWriter w = writers.peek();
		w.get().visitTypeInsn(NEW, functionClass(fw.getNumber()));
		w.get().visitInsn(DUP);
		for (FunctionWriter writer : writers) {
			w.get().visitVarInsn(ALOAD, 0);
			w.get().visitFieldInsn(GETFIELD, functionClass(w.getNumber()),
					scopeName(writer.getNumber()), scopeType(writer.getNumber()));
		}
		w.get().visitMethodInsn(INVOKESPECIAL,
				functionClass(fw.getNumber()), "<init>", fw.getSignature());
		return null;
	}

	@Override
	public Object visit(FunctionParameterNode functionParam) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object visit(GeNode ge) {
		ge.getLhs().accept(this);
		ge.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "ge", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(GtNode gt) {
		gt.getLhs().accept(this);
		gt.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "gt", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(IfElseNode ifElse) {
		Label elseBlock = new Label();
		Label end = new Label();;
		ifElse.getCondition().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "toInt", "()I"); // 0(false) or 1(true)
		writers.peek().get().visitJumpInsn(IFEQ, elseBlock); // if x == 0
		ifElse.getIfStatement().accept(this);
		writers.peek().get().visitJumpInsn(GOTO, end);
		writers.peek().get().visitLabel(elseBlock);
		if (ifElse.getElseStatement() != null) {
			ifElse.getElseStatement().accept(this);
		}
		writers.peek().get().visitLabel(end);
		return null;
	}

	public Object visit(LeNode le) {
		le.getLhs().accept(this);
		le.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "le", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(LtNode lt) {
		lt.getLhs().accept(this);
		lt.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "lt", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(ModNode mod) {
		mod.getLhs().accept(this);
		mod.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "mod", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(MulNode mul) {
		mul.getLhs().accept(this);
		mul.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "mul", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(NegNode neg) {
		neg.getExpression().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "neg", UNARY_SIGNATURE);
		return null;
	}

	public Object visit(NeNode ne) {
		ne.getLhs().accept(this);
		ne.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "ne", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(NotNode not) {
		not.getExpression().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "not", UNARY_SIGNATURE);
		return null;
	}

	public Object visit(NumberNode number) {
		writers.peek().get().visitTypeInsn(NEW, Class.NUMBER);
		writers.peek().get().visitInsn(DUP);
		writers.peek().get().visitLdcInsn(number.getValue());
		writers.peek().get().visitMethodInsn(INVOKESPECIAL,
				Class.NUMBER, "<init>", "(Ljava/lang/String;)V");
		return null;
	}

	public Object visit(OrNode or) {
		or.getLhs().accept(this);
		or.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "or", BINARY_SIGNATURE);
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
		writers.peek().visit();
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
		mv.visitMaxs(20, 20); // ??
		mv.visitEnd();
		
		writeFile(cw, fileName);
		return null;
	}

	public Object visit(ReturnNode returnStat) {
		if (returnStat.getValue() != null) {
			returnStat.getValue().accept(this);
		} else {
			writers.peek().get().visitFieldInsn(
					GETSTATIC, Type.UNDEF, "UNDEF", Type.UNDEF);
		}
		writers.peek().get().visitInsn(ARETURN);
		return null;
	}

	public Object visit(StringNode string) {
		writers.peek().get().visitTypeInsn(NEW, Class.STRING);
		writers.peek().get().visitInsn(DUP);
		writers.peek().get().visitLdcInsn(string.getValue());
		writers.peek().get().visitMethodInsn(INVOKESPECIAL,
				Class.STRING, "<init>", "(Ljava/lang/String;)V");
		return null;
	}

	public Object visit(SubNode sub) {
		sub.getLhs().accept(this);
		sub.getRhs().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "sub", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(UndefNode undef) {
		writers.peek().get().visitFieldInsn(
				GETSTATIC, Type.UNDEF, "UNDEF", Type.UNDEF);
		return null;
	}

	public Object visit(VarNode var) {
		int number = findScopeNumber(var);
		FunctionWriter w = writers.peek();
		w.get().visitVarInsn(ALOAD, 0);
		w.get().visitFieldInsn(GETFIELD,functionClass(w.getNumber()),
				scopeName(number), scopeType(number));
		w.get().visitFieldInsn(GETFIELD, scopeClass(number), var.getName(), Type.OBJECT);
		return null;
	}

	public Object visit(WhileNode whileStat) {
		Label loopStart = new Label();
		Label loopEnd = new Label();
		writers.peek().get().visitLabel(loopStart);
		whileStat.getCondition().accept(this);
		writers.peek().get().visitMethodInsn(
				INVOKEVIRTUAL, Class.OBJECT, "toInt", "()I"); // 0(false) or 1(true)
		writers.peek().get().visitJumpInsn(IFEQ, loopEnd); // if x == false
		whileStat.getStatement().accept(this);
		writers.peek().get().visitJumpInsn(GOTO, loopStart);
		writers.peek().get().visitLabel(loopEnd);
		return null;
	}

}

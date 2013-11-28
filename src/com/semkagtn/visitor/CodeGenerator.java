package com.semkagtn.visitor;

import java.io.FileOutputStream;
import java.io.IOException;

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

	//private int functionCounter;
	private String fileName;
	//private LinkedList<FunctionWriter> writers;
	private MethodVisitor mv;
	
	private static final String RUNTIME_PACKAGE = "com/semkagtn/runtime/";
	
	private class Type {
		public static final String OBJECT = RUNTIME_PACKAGE + "JSObject";
		public static final String BOOL = RUNTIME_PACKAGE + "JSBool";
		public static final String UNDEF = RUNTIME_PACKAGE + "JSUndef";
		public static final String STRING = RUNTIME_PACKAGE + "JSString";
		public static final String NUMBER = RUNTIME_PACKAGE + "JSNumber";
		public static final String FUNCTION = RUNTIME_PACKAGE + "JSFunction";
	}
	
	private class LType {
		public static final String OBJECT = "L" + Type.OBJECT + ';';
		public static final String BOOL = "L" + Type.BOOL + ';';
		public static final String UNDEF = "L" + Type.UNDEF + ';';
		public static final String STRING = "L" + Type.STRING + ';';
		public static final String NUMBER = "L" + Type.NUMBER + ';';
		public static final String FUNCTION = "L" + Type.NUMBER + ';';
	}
	
	public static final String CALL_SIGNATURE = "([" + LType.OBJECT + ")" +  LType.OBJECT;
	public static final String BINARY_SIGNATURE  = "(" + LType.OBJECT + ")" + LType.OBJECT;
	public static final String UNARY_SIGNATURE  = "()" + LType.OBJECT;
	/*
	private class FunctionWriter {
		private ClassWriter cw;
		private MethodVisitor mv;
		private FunctionNode function;
		private int number;
		
		public String functionName() {
			return fileName + "$Function" + number;
		}
		
		private String scopeClassName() {
			return fileName + "$Scope" + number;
		}
		
		private void generateScopeClass() {
			ClassWriter cw = new ClassWriter(0);
			cw.visit(V1_1, ACC_PUBLIC, scopeClassName(), null, "java/lang/Object", null);
			for (String var : function.getVariables()) {
				cw.visitField(ACC_PUBLIC, var, LType.OBJECT, null, null);
			}
			
			MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
			for (String var : function.getVariables()) {
				mv.visitVarInsn(ALOAD, 0);
				mv.visitFieldInsn(GETSTATIC, Type.UNDEF, "UNDEF", LType.UNDEF);
				mv.visitFieldInsn(PUTFIELD, scopeClassName(), var, LType.UNDEF);
			}
			mv.visitInsn(RETURN);
			mv.visitMaxs(2, 2); // ??
			mv.visitEnd();
			
			cw.visitEnd();
			
			try {
				byte[] code = cw.toByteArray();
				FileOutputStream fos = new FileOutputStream(scopeClassName() + ".class");
				fos.write(code);
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public FunctionWriter(FunctionNode function) {
			this.function = function;
			number = functionCounter;
			++functionCounter;
			cw = new ClassWriter(0);
		}
		
		public void visit() {
			// Constructor
			generateScopeClass();
			cw.visit(V1_1, ACC_PUBLIC, functionName(), null, Type.FUNCTION, null);
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitMethodInsn(INVOKESPECIAL, Type.FUNCTION, "<init>", "(Ljava/lang/String;)V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(2, 2); // ?
			mv.visitEnd();
			
			// Method call
		}
	}*/
	
	
	// test
	private void generateScopeClass(FunctionNode function) {
		ClassWriter cw = new ClassWriter(0);
		cw.visit(V1_1, ACC_PUBLIC, "JSScope", null, "java/lang/Object", null);
		for (String var : function.getVariables()) {
			cw.visitField(ACC_PUBLIC, var, LType.OBJECT, null, null);
		}
		
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		for (String var : function.getVariables()) {
			mv.visitVarInsn(ALOAD, 0);
			mv.visitFieldInsn(GETSTATIC, Type.UNDEF, "UNDEF", LType.UNDEF);
			mv.visitFieldInsn(PUTFIELD, "JSScope", var, LType.OBJECT);
		}
		mv.visitInsn(RETURN);
		mv.visitMaxs(2, 2); // ??
		mv.visitEnd();
		
		cw.visitEnd();
		
		try {
			byte[] code = cw.toByteArray();
			FileOutputStream fos = new FileOutputStream("JSScope" + ".class");
			fos.write(code);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// test
	
	public CodeGenerator(String fileName) {
		//functionCounter = 0;
		this.fileName = fileName;
	}
	
	public Object visit(AddNode add) {
		add.getLhs().accept(this);
		add.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "add", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(AndNode and) {
		and.getLhs().accept(this);
		and.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "and", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(AssignmentNode assign) {
		mv.visitVarInsn(ALOAD, 1);
		assign.getExpression().accept(this);
		mv.visitFieldInsn(PUTFIELD, "JSScope",
				assign.getVariable().getName(), LType.OBJECT);
		mv.visitVarInsn(ALOAD, 1);
		mv.visitFieldInsn(GETFIELD, "JSScope",
				assign.getVariable().getName(), LType.OBJECT);
		return null;
	}

	public Object visit(BlockNode block) {
		for (StatementNode stat: block.getBody()) {
			stat.accept(this);
		}
		return null;
	}


	public Object visit(BoolNode bool) {
		mv.visitFieldInsn(GETSTATIC, Type.BOOL,
				bool.getValue().toUpperCase(), LType.BOOL);
		return null;
	}

	public Object visit(DivNode div) {
		div.getLhs().accept(this);
		div.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "div", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(EqNode eq) {
		eq.getLhs().accept(this);
		eq.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "eq", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(ExpressionStatementNode exprStat) {
		exprStat.getExpression().accept(this);
		mv.visitInsn(POP);
		return null;
	}

	public Object visit(FunctionCallNode functionCall) {
		ExpressionNode arg = functionCall.getArguments().get(0);
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		arg.accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/Object;)V");
		mv.visitFieldInsn(GETSTATIC, Type.UNDEF, "UNDEF", LType.UNDEF);
		return null;
	}

	@Override
	public Object visit(FunctionNode function) {
		// TODO Auto-generated method stub
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
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "ge", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(GtNode gt) {
		gt.getLhs().accept(this);
		gt.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "gt", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(IfElseNode ifElse) {
		Label elseBlock = new Label();
		Label end = new Label();;
		ifElse.getCondition().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "toInt", "()I");
		mv.visitJumpInsn(IFEQ, elseBlock);
		ifElse.getIfStatement().accept(this);
		mv.visitJumpInsn(GOTO, end);
		mv.visitLabel(elseBlock);
		if (ifElse.getElseStatement() != null) {
			ifElse.getElseStatement().accept(this);
		}
		mv.visitLabel(end);
		return null;
	}

	public Object visit(LeNode le) {
		le.getLhs().accept(this);
		le.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "le", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(LtNode lt) {
		lt.getLhs().accept(this);
		lt.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "lt", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(ModNode mod) {
		mod.getLhs().accept(this);
		mod.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "mod", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(MulNode mul) {
		mul.getLhs().accept(this);
		mul.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "mul", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(NegNode neg) {
		neg.getExpression().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "neg", UNARY_SIGNATURE);
		return null;
	}

	public Object visit(NeNode ne) {
		ne.getLhs().accept(this);
		ne.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "ne", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(NotNode not) {
		not.getExpression().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "not", UNARY_SIGNATURE);
		return null;
	}

	public Object visit(NumberNode number) {
		mv.visitTypeInsn(NEW, Type.NUMBER);
		mv.visitInsn(DUP);
		mv.visitLdcInsn(number.getValue());
		mv.visitMethodInsn(INVOKESPECIAL, Type.NUMBER, "<init>", "(Ljava/lang/String;)V");
		return null;
	}

	public Object visit(OrNode or) {
		or.getLhs().accept(this);
		or.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "or", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(ProgramNode program) {
		// test
		generateScopeClass(program);
		// test
		ClassWriter cw = new ClassWriter(0);
		cw.visit(V1_1, ACC_PUBLIC, fileName, null, "java/lang/Object", null);
		
		mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		mv.visitInsn(RETURN);
		mv.visitMaxs(2, 2); // ??
		mv.visitEnd();
		
		mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", 
				"([Ljava/lang/String;)V", null, null);
		// test
		mv.visitTypeInsn(NEW, "JSScope");
		mv.visitInsn(DUP);
		mv.visitMethodInsn(INVOKESPECIAL, "JSScope", "<init>", "()V");
		mv.visitVarInsn(ASTORE, 1);
		for (StatementNode stat : program.getBody()) {
			stat.accept(this);
		}
		// test
		mv.visitInsn(RETURN);
		mv.visitMaxs(10, 10); // ??
		mv.visitEnd();
		
		cw.visitEnd();
		try {
			byte[] code = cw.toByteArray();
			FileOutputStream fos = new FileOutputStream(fileName + ".class");
			fos.write(code);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object visit(ReturnNode returnStat) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visit(StringNode string) {
		mv.visitTypeInsn(NEW, Type.STRING);
		mv.visitInsn(DUP);
		mv.visitLdcInsn(string.getValue());
		mv.visitMethodInsn(INVOKESPECIAL, Type.STRING, "<init>", "(Ljava/lang/String;)V");
		return null;
	}

	public Object visit(SubNode sub) {
		sub.getLhs().accept(this);
		sub.getRhs().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "sub", BINARY_SIGNATURE);
		return null;
	}

	public Object visit(UndefNode undef) {
		mv.visitFieldInsn(GETSTATIC, Type.UNDEF, "UNDEF", LType.UNDEF);
		return null;
	}

	public Object visit(VarNode var) {
		mv.visitVarInsn(ALOAD, 1);
		mv.visitFieldInsn(GETFIELD, "JSScope", var.getName(), LType.OBJECT);
		return null;
	}

	public Object visit(WhileNode whileStat) {
		Label loopStart = new Label();
		Label loopEnd = new Label();
		mv.visitLabel(loopStart);
		whileStat.getCondition().accept(this);
		mv.visitMethodInsn(INVOKEVIRTUAL, Type.OBJECT, "toInt", "()I");
		mv.visitJumpInsn(IFEQ, loopEnd);
		whileStat.getStatement().accept(this);
		mv.visitJumpInsn(GOTO, loopStart);
		mv.visitLabel(loopEnd);
		return null;
	}

}

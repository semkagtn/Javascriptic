package com.semkagtn.visitor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.semkagtn.runtime.JSUndef;
import com.semkagtn.tree.AddNode;
import com.semkagtn.tree.AndNode;
import com.semkagtn.tree.AssignmentNode;
import com.semkagtn.tree.BlockNode;
import com.semkagtn.tree.BoolNode;
import com.semkagtn.tree.BreakNode;
import com.semkagtn.tree.ContinueNode;
import com.semkagtn.tree.DivNode;
import com.semkagtn.tree.EqNode;
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
import com.semkagtn.tree.StringNode;
import com.semkagtn.tree.SubNode;
import com.semkagtn.tree.UndefNode;
import com.semkagtn.tree.VarNode;
import com.semkagtn.tree.WhileNode;

public class CodeGenerator implements AstVisitor<Object>, Opcodes {

	private int functionCounter;
	private String fileName;
	private LinkedList<FunctionWriter> writers;
	
	private static final String RUNTIME_PACKAGE = "com/semkagtn/runtime/";
	
	private class Type {
		public static final String OBJECT = RUNTIME_PACKAGE + "JSObject";
		public static final String BOOL = RUNTIME_PACKAGE + "JSBool";
		public static final String UNDEF = RUNTIME_PACKAGE + "JSOUndef";
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
	
	public static final String CALL_SIG = "([" + LType.OBJECT + ")" +  LType.OBJECT; 
	
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
	}
	
	public CodeGenerator(String fileName) {
		functionCounter = 0;
		this.fileName = fileName;
	}
	
	@Override
	public Object visit(AddNode add) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AndNode and) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AssignmentNode assign) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(BlockNode block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(BoolNode bool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(BreakNode breakStat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ContinueNode continueStat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DivNode div) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(EqNode eq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ExpressionStatementNode exprStat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FunctionCallNode functionCall) {
		// TODO Auto-generated method stub
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

	@Override
	public Object visit(GeNode ge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GtNode gt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IfElseNode ifElse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LeNode le) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LtNode lt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ModNode mod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MulNode mul) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NegNode neg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NeNode ne) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotNode not) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NumberNode number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(OrNode or) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visit(ProgramNode program) {
		ClassWriter cw = new ClassWriter(0);
		cw.visit(V1_1, ACC_PUBLIC, fileName, null, "java/lang/Object", null);
		
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		mv.visitInsn(RETURN);
		mv.visitMaxs(2, 2); // ??
		mv.visitEnd();
		
		mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", 
				"([Ljava/lang/String;)V", null, null);
		
		writers.push(new FunctionWriter(program));
		// ... call 'call()' method of main function (Function0)
		writers.pop();
		
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

	@Override
	public Object visit(StringNode string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(SubNode sub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(UndefNode undef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VarNode var) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WhileNode whileStat) {
		// TODO Auto-generated method stub
		return null;
	}

}

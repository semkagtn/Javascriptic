package com.semkagtn.visitor;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.semkagtn.generated.JavascripticBaseVisitor;
import com.semkagtn.generated.JavascripticParser;
import com.semkagtn.generated.JavascripticParser.AddSubContext;
import com.semkagtn.generated.JavascripticParser.AndContext;
import com.semkagtn.generated.JavascripticParser.AssignContext;
import com.semkagtn.generated.JavascripticParser.BlockStatContext;
import com.semkagtn.generated.JavascripticParser.BreakStatContext;
import com.semkagtn.generated.JavascripticParser.CmpContext;
import com.semkagtn.generated.JavascripticParser.ConstantContext;
import com.semkagtn.generated.JavascripticParser.ContinueStatContext;
import com.semkagtn.generated.JavascripticParser.EqContext;
import com.semkagtn.generated.JavascripticParser.ExprContext;
import com.semkagtn.generated.JavascripticParser.ExprStatContext;
import com.semkagtn.generated.JavascripticParser.FunctionCallContext;
import com.semkagtn.generated.JavascripticParser.FunctionContext;
import com.semkagtn.generated.JavascripticParser.IfStatContext;
import com.semkagtn.generated.JavascripticParser.MulDivModContext;
import com.semkagtn.generated.JavascripticParser.OrContext;
import com.semkagtn.generated.JavascripticParser.ParensContext;
import com.semkagtn.generated.JavascripticParser.ProgramContext;
import com.semkagtn.generated.JavascripticParser.ReturnStatContext;
import com.semkagtn.generated.JavascripticParser.StatContext;
import com.semkagtn.generated.JavascripticParser.UnaryExprContext;
import com.semkagtn.generated.JavascripticParser.VarContext;
import com.semkagtn.generated.JavascripticParser.VarDeclStatContext;
import com.semkagtn.generated.JavascripticParser.WhileStatContext;
import com.semkagtn.tree.AddNode;
import com.semkagtn.tree.AndNode;
import com.semkagtn.tree.AssignmentNode;
import com.semkagtn.tree.AstNode;
import com.semkagtn.tree.BinaryExpressionNode;
import com.semkagtn.tree.BlockNode;
import com.semkagtn.tree.BreakNode;
import com.semkagtn.tree.ConstantNode;
import com.semkagtn.tree.ContinueNode;
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
import com.semkagtn.tree.OrNode;
import com.semkagtn.tree.ProgramNode;
import com.semkagtn.tree.ReturnNode;
import com.semkagtn.tree.StatementNode;
import com.semkagtn.tree.SubNode;
import com.semkagtn.tree.Type;
import com.semkagtn.tree.UnaryExpressionNode;
import com.semkagtn.tree.VarDeclarationNode;
import com.semkagtn.tree.VarNode;
import com.semkagtn.tree.WhileNode;

public class AstBuilder extends JavascripticBaseVisitor<AstNode> {
	public ProgramNode visitProgram(ProgramContext ctx) {
		ProgramNode program = new ProgramNode();
		program.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		for (StatContext stat : ctx.stat()) {
			program.addStatement((StatementNode) visit(stat));
//			System.out.println(program.getBody().get(program.getBody().size() - 1));
		}
		return program;
	}
	
	public AstNode visitStat(StatContext ctx) {
		return visitChildren(ctx);
	}
	
	public BlockNode visitBlockStat(BlockStatContext ctx) {
		BlockNode block = new BlockNode();
		block.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		for (StatContext stat : ctx.stat()) {
			block.addStatement((StatementNode) visit(stat));
		}
		return block;
	}
	
	public VarDeclarationNode visitVarDeclStat(VarDeclStatContext ctx) {
		VarDeclarationNode varDecl = new VarDeclarationNode();
		varDecl.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		varDecl.setName(ctx.ID().toString());
		if (ctx.expr() != null) {
			varDecl.setInitialValue((ExpressionNode) visit(ctx.expr()));
		}
		return varDecl;
	}
	
	public IfElseNode visitIfStat(IfStatContext ctx) {
		IfElseNode ifElse = new IfElseNode();
		ifElse.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		ifElse.setCondition((ExpressionNode) visit(ctx.expr()));
		ifElse.setIfStatement((StatementNode) visit(ctx.stat(0)));
		if (ctx.stat(1) != null) {
			ifElse.setElseStatement((StatementNode) visit(ctx.stat(1)));
		}
		return ifElse;
	}
	
	public WhileNode visitWhileStat(WhileStatContext ctx) {
		WhileNode whileNode = new WhileNode();
		whileNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		whileNode.setCondition((ExpressionNode) visit(ctx.expr()));
		whileNode.setStatement((StatementNode) visit(ctx.stat()));
		return whileNode;
	}
	
	public ReturnNode visitReturnStat(ReturnStatContext ctx) {
		ReturnNode returnNode = new ReturnNode();
		returnNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		if (ctx.expr() != null) {
			returnNode.setValue((ExpressionNode) visit(ctx.expr()));
		}
		return returnNode;
	}
	
	public BreakNode visitBreakStat(BreakStatContext ctx) {
		BreakNode breakNode = new BreakNode();
		breakNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		return breakNode;
	}
	
	public ContinueNode visitContinueStat(ContinueStatContext ctx) {
		ContinueNode continueNode = new ContinueNode();
		continueNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		return continueNode;
	}
	
	public ExpressionStatementNode visitExprStat(ExprStatContext ctx) {
		ExpressionStatementNode statement = new ExpressionStatementNode();
		statement.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		statement.setExpression((ExpressionNode) visit(ctx.expr()));
		return statement;
	}
	
	public AstNode visitExpr(ExprContext ctx) {
		return visitChildren(ctx);
	}
	
	public AstNode visitParens(ParensContext ctx) {
		return visit(ctx.expr());
	}
	
	public FunctionCallNode visitFunctionCall(FunctionCallContext ctx) {
		FunctionCallNode functionCall = new FunctionCallNode();
		functionCall.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		functionCall.setFunction((ExpressionNode) visit(ctx.expr()));
		if (ctx.functionArgs() != null) {
			for (ExprContext arg : ctx.functionArgs().expr()) {
				functionCall.addArgument((ExpressionNode) visit(arg));
			}
		}
		return functionCall;
	}
	
	public UnaryExpressionNode visitUnaryExpr(UnaryExprContext ctx) {
		UnaryExpressionNode unary;
		if (ctx.op.getType() == JavascripticParser.NOT) {
			unary = new NotNode();
		} else {
			unary = new NegNode();
		}
		unary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		unary.setExpression((ExpressionNode) visit(ctx.expr()));
		return unary;
	}
	
	public BinaryExpressionNode visitMulDivMod(MulDivModContext ctx) {
		BinaryExpressionNode binary;
		if (ctx.op.getType() == JavascripticParser.MUL) {
			binary = new MulNode();
		} else if (ctx.op.getType() == JavascripticParser.DIV) {
			binary = new DivNode();
		} else {
			binary = new ModNode();
		}
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitAddSub(AddSubContext ctx) {
		BinaryExpressionNode binary;
		if (ctx.op.getType() == JavascripticParser.ADD) {
			binary = new AddNode();
		} else {
			binary = new SubNode();
		}
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitCmp(CmpContext ctx) {
		BinaryExpressionNode binary;
		if (ctx.op.getType() == JavascripticParser.LT) {
			binary = new LtNode();
		} else if (ctx.op.getType() == JavascripticParser.LE) {
			binary = new LeNode();
		} else if (ctx.op.getType() == JavascripticParser.GT){
			binary = new GtNode();
		} else {
			binary = new GeNode();
		}
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitEq(EqContext ctx) {
		BinaryExpressionNode binary;
		if (ctx.op.getType() == JavascripticParser.EQ) {
			binary = new EqNode();
		} else {
			binary = new NeNode();
		}
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitAnd(AndContext ctx) {
		BinaryExpressionNode binary = new AndNode();
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitOr(OrContext ctx) {
		BinaryExpressionNode binary = new OrNode();
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public AssignmentNode visitAssign(AssignContext ctx) {
		AssignmentNode assignment = new AssignmentNode();
		assignment.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		assignment.setVariableName(ctx.ID().getText());
		assignment.setExpression((ExpressionNode) visit(ctx.expr()));
		return assignment;
	}
	
	public VarNode visitVar(VarContext ctx) {
		VarNode variable = new VarNode();
		variable.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		variable.setName(ctx.ID().getText());
		return variable;
	}
	
	public ConstantNode visitConstant(ConstantContext ctx) {
		ConstantNode constant = new ConstantNode();
		constant.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		if (ctx.NUM() != null) {
			constant.setType(Type.NUM);
			constant.setValue(ctx.NUM().getText());
		} else if (ctx.STR() != null) {
			constant.setType(Type.STR);
			constant.setValue(ctx.STR().getText().replace("\"", ""));
		} else if (ctx.BOOL() != null) {
			constant.setType(Type.BOOL);
			constant.setValue(ctx.BOOL().getText());
		} else if (ctx.NAN() != null) {
			constant.setType(Type.NAN);
			constant.setValue(ctx.NAN().getText());
		} else {
			constant.setType(Type.UNDEF);
			constant.setValue(ctx.UNDEF().getText());
		}
		return constant;
	}
	
	public FunctionNode visitFunction(FunctionContext ctx) {
		FunctionNode function = new FunctionNode();
		function.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		function.setType(Type.FUNCTION);
		function.setValue("function");
		if (ctx.functionParams() != null) {
			for (TerminalNode paramName : ctx.functionParams().ID()) {
				FunctionParameterNode param = new FunctionParameterNode();
				param.setName(paramName.getText());
				function.addParameter(param);
			}
		}
		for (StatContext statement : ctx.blockStat().stat()) {
			function.addStatement((StatementNode) visit(statement)); 
		}
		return function;
	}
}

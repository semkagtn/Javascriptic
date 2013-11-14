package com.semkagtn.tree;

import com.semkagtn.generated.JavascripticBaseVisitor;
import com.semkagtn.generated.JavascripticParser;
import com.semkagtn.generated.JavascripticParser.AddSubExprContext;
import com.semkagtn.generated.JavascripticParser.AndExprContext;
import com.semkagtn.generated.JavascripticParser.AssignExprContext;
import com.semkagtn.generated.JavascripticParser.BlockStatContext;
import com.semkagtn.generated.JavascripticParser.BreakStatContext;
import com.semkagtn.generated.JavascripticParser.CmpExprContext;
import com.semkagtn.generated.JavascripticParser.ConstantContext;
import com.semkagtn.generated.JavascripticParser.ContinueStatContext;
import com.semkagtn.generated.JavascripticParser.DoWhileStatContext;
import com.semkagtn.generated.JavascripticParser.EqExprContext;
import com.semkagtn.generated.JavascripticParser.ExprContext;
import com.semkagtn.generated.JavascripticParser.ExprStatContext;
import com.semkagtn.generated.JavascripticParser.FunctionCallExprContext;
import com.semkagtn.generated.JavascripticParser.FunctionDeclContext;
import com.semkagtn.generated.JavascripticParser.IfStatContext;
import com.semkagtn.generated.JavascripticParser.MulDivModExprContext;
import com.semkagtn.generated.JavascripticParser.OrExprContext;
import com.semkagtn.generated.JavascripticParser.ParamContext;
import com.semkagtn.generated.JavascripticParser.ParenExprContext;
import com.semkagtn.generated.JavascripticParser.ProgramContext;
import com.semkagtn.generated.JavascripticParser.ReturnStatContext;
import com.semkagtn.generated.JavascripticParser.StatContext;
import com.semkagtn.generated.JavascripticParser.UnaryExprContext;
import com.semkagtn.generated.JavascripticParser.VarDeclContext;
import com.semkagtn.generated.JavascripticParser.VariableContext;
import com.semkagtn.generated.JavascripticParser.WhileStatContext;

public class AstBuilder extends JavascripticBaseVisitor<Node> {
	public ProgramNode visitProgram(ProgramContext ctx) {
		ProgramNode program = new ProgramNode();
		program.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		if (!ctx.stat().isEmpty()) {
			for (StatContext statement : ctx.stat()) {
				program.addStatement((StatementNode) visit(statement));
			}
		}
		return program;
	}
	
	public Node visitStat(StatContext ctx) {
		return visitChildren(ctx);
	}
	
	public BlockNode visitScopeStat(BlockStatContext ctx) {
		BlockNode scope = new BlockNode();
		scope.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		for (StatContext statement : ctx.stat()) {
			scope.addStatement((StatementNode) visit(statement));
		}
		return scope;
	}
	
	public FunctionNode visitFunctionDecl(FunctionDeclContext ctx) {
		FunctionNode function = new FunctionNode();
		function.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		function.setName(ctx.ID().toString());
		if (ctx.functionParams() != null) {
			for (ParamContext param : ctx.functionParams().param()) {
				function.addParameter((FunctionParameterNode) visit(param));
			}
		}
		for (StatContext statement : ctx.blockStat().stat()) {
			function.addStatement((StatementNode) visit(statement)); 
		}
		return function;
	}
	
	public VariableDeclarationNode visitVarDecl(VarDeclContext ctx) {
		VariableDeclarationNode variableDecl = new VariableDeclarationNode();
		variableDecl.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		variableDecl.setName(ctx.ID().toString());
		if (ctx.expr() != null) {
			variableDecl.setInitialValue((ExpressionNode) visit(ctx.expr()));
		}
		return variableDecl;
	}
	
	public IfElseNode visitIfStat(IfStatContext ctx) {
		IfElseNode ifElse = new IfElseNode();
		ifElse.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		ifElse.setCondition((ExpressionNode) visit(ctx.expr()));
		if (ctx.stat(0).blockStat() == null) {
			ifElse.addIfStatement((StatementNode) visit(ctx.stat(0)));
		} else {
			for (StatContext statement : ctx.stat(0).blockStat().stat()) {
				ifElse.addIfStatement((StatementNode) visit(statement));
			}
		}
		if (ctx.stat(1) != null) {
			if (ctx.stat(1).blockStat() == null) {
				ifElse.addElseStatement((StatementNode) visit(ctx.stat(1)));
			} else {
				for (StatContext statement : ctx.stat(1).blockStat().stat()) {
					ifElse.addElseStatement((StatementNode) visit(statement));
				}
			}
		}
		return ifElse;
	}
	
	public WhileNode visitWhileStat(WhileStatContext ctx) {
		WhileNode whileNode = new WhileNode();
		whileNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		whileNode.setCondition((ExpressionNode) visit(ctx.expr()));
		if (ctx.stat().blockStat() == null) {
			whileNode.addStatement((StatementNode) visit(ctx.stat()));
		} else {
			for (StatContext statement : ctx.stat().blockStat().stat()) {
				whileNode.addStatement((StatementNode) visit(statement));
			}
		}
		return whileNode;
	}
	
	public DoWhileNode visitDoWhileStat(DoWhileStatContext ctx) {
		DoWhileNode doWhileNode = new DoWhileNode();
		doWhileNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		doWhileNode.setCondition((ExpressionNode) visit(ctx.expr()));
		if (ctx.stat().blockStat() == null) {
			doWhileNode.addStatement((StatementNode) visit(ctx.stat()));
		} else {
			for (StatContext statement : ctx.stat().blockStat().stat()) {
				doWhileNode.addStatement((StatementNode) visit(statement));
			}
		}
		return doWhileNode;
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
	
	public Node visitExpr(ExprContext ctx) {
		return visitChildren(ctx);
	}
	
	public UnaryExpressionNode visitUnaryExpr(UnaryExprContext ctx) {
		UnaryExpressionNode unary;
		if (ctx.op.getType() == JavascripticParser.NOT) {
			unary = new NotExpressionNode();
		} else {
			unary = new NegExpressionNode();
		}
		unary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		unary.setExpression((ExpressionNode) visit(ctx.expr()));
		return unary;
	}
	
	public BinaryExpressionNode visitMulDivModExpr(MulDivModExprContext ctx) {
		BinaryExpressionNode binary;
		if (ctx.op.getType() == JavascripticParser.MUL) {
			binary = new MulExpressionNode();
		} else if (ctx.op.getType() == JavascripticParser.DIV) {
			binary = new DivExpressionNode();
		} else {
			binary = new ModExpressionNode();
		}
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitAddSubExpr(AddSubExprContext ctx) {
		BinaryExpressionNode binary;
		if (ctx.op.getType() == JavascripticParser.ADD) {
			binary = new AddExpressionNode();
		} else {
			binary = new SubExpressionNode();
		}
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitCmpExpr(CmpExprContext ctx) {
		BinaryExpressionNode binary;
		if (ctx.op.getType() == JavascripticParser.LT) {
			binary = new LtExpressionNode();
		} else if (ctx.op.getType() == JavascripticParser.LE) {
			binary = new LeExpressionNode();
		} else if (ctx.op.getType() == JavascripticParser.GT){
			binary = new GtExpressionNode();
		} else {
			binary = new GeExpressionNode();
		}
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitEqExpr(EqExprContext ctx) {
		BinaryExpressionNode binary;
		if (ctx.op.getType() == JavascripticParser.EQ) {
			binary = new EqExpressionNode();
		} else {
			binary = new NeExpressionNode();
		}
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitAndExpr(AndExprContext ctx) {
		BinaryExpressionNode binary = new AndExpressionNode();
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitOrExpr(OrExprContext ctx) {
		BinaryExpressionNode binary = new OrExpressionNode();
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public AssignmentNode visitAssignExpr(AssignExprContext ctx) {
		AssignmentNode assignment = new AssignmentNode();
		assignment.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		assignment.setVariableName(ctx.ID().getText());
		assignment.setExpression((ExpressionNode) visit(ctx.expr()));
		return assignment;
	}
	
	public Node visitParenExpr(ParenExprContext ctx) {
		return visit(ctx.expr());
	}
	
	public VariableNode visitVariable(VariableContext ctx) {
		VariableNode variable = new VariableNode();
		variable.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		variable.setName(ctx.ID().getText());
		return variable;
	}
	
	public ConstantNode visitConstant(ConstantContext ctx) {
		ConstantNode constant = new ConstantNode();
		constant.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		if (ctx.constantExpr().NUM() != null) {
			constant.setType(Type.NUM);
			constant.setValue(ctx.constantExpr().NUM().getText());
		} else if (ctx.constantExpr().STR() != null) {
			constant.setType(Type.STR);
			constant.setValue(ctx.constantExpr().STR().getText().replace("\"", ""));
		} else if (ctx.constantExpr().BOOL() != null) {
			constant.setType(Type.BOOL);
			constant.setValue(ctx.constantExpr().BOOL().getText());
		} else {
			constant.setType(Type.UNDEF);
			constant.setValue(ctx.constantExpr().UNDEF().toString());
		}
		return constant;
	}
	
	public FunctionCallNode visitFunctionCallExpr(FunctionCallExprContext ctx) {
		FunctionCallNode functionCall = new FunctionCallNode();
		functionCall.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		functionCall.setName(ctx.ID().toString());
		if (ctx.functionArgs() != null) {
			for (ExprContext arg : ctx.functionArgs().expr()) {
				functionCall.addArgument((ExpressionNode) visit(arg));
			}
		}
		return functionCall;
	}
	
	public FunctionParameterNode visitParam(ParamContext ctx) {
		FunctionParameterNode param = new FunctionParameterNode();
		param.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		param.setName(ctx.ID().toString());
		return param;
	}
}

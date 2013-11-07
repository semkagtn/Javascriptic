package com.semkagtn.tree;

import com.semkagtn.generated.JavascripticBaseVisitor;
import com.semkagtn.generated.JavascripticParser;
import com.semkagtn.generated.JavascripticParser.AddSubExprContext;
import com.semkagtn.generated.JavascripticParser.AndExprContext;
import com.semkagtn.generated.JavascripticParser.AssignExprContext;
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
import com.semkagtn.generated.JavascripticParser.ScopeStatContext;
import com.semkagtn.generated.JavascripticParser.StatContext;
import com.semkagtn.generated.JavascripticParser.UnaryExprContext;
import com.semkagtn.generated.JavascripticParser.VarDeclContext;
import com.semkagtn.generated.JavascripticParser.VariableContext;
import com.semkagtn.generated.JavascripticParser.WhileStatContext;

public class AstBuilder extends JavascripticBaseVisitor<Node> {
	public ProgramNode visitProgram(ProgramContext ctx) {
		ProgramNode program = new ProgramNode();
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
	
	public ScopeNode visitScopeStat(ScopeStatContext ctx) {
		ScopeNode scope = new ScopeNode();
		for (StatContext statement : ctx.stat()) {
			scope.addStatement((StatementNode) visit(statement));
		}
		return scope;
	}
	
	public FunctionNode visitFunctionDecl(FunctionDeclContext ctx) {
		FunctionNode function = new FunctionNode();
		function.setName(ctx.ID().toString());
		if (ctx.functionParams() != null) {
			for (ParamContext param : ctx.functionParams().param()) {
				function.addParameter((FunctionParameterNode) visit(param));
			}
		}
		for (StatContext statement : ctx.scopeStat().stat()) {
			function.addStatement((StatementNode) visit(statement)); 
		}
		return function;
	}
	
	public VariableDeclarationNode visitVarDecl(VarDeclContext ctx) {
		VariableDeclarationNode variableDecl = new VariableDeclarationNode();
		variableDecl.setName(ctx.ID().toString());
		if (ctx.expr() != null) {
			variableDecl.setInitialValue((ExpressionNode) visit(ctx.expr()));
		}
		return variableDecl;
	}
	
	public IfElseNode visitIfStat(IfStatContext ctx) {
		IfElseNode ifElse = new IfElseNode();
		ifElse.setCondition((ExpressionNode) visit(ctx.expr()));
		if (ctx.stat(0).scopeStat() == null) {
			ifElse.addIfStatement((StatementNode) visit(ctx.stat(0)));
		} else {
			for (StatContext statement : ctx.stat(0).scopeStat().stat()) {
				ifElse.addIfStatement((StatementNode) visit(statement));
			}
		}
		if (ctx.stat(1) != null) {
			if (ctx.stat(1).scopeStat() == null) {
				ifElse.addElseStatement((StatementNode) visit(ctx.stat(1)));
			} else {
				for (StatContext statement : ctx.stat(1).scopeStat().stat()) {
					ifElse.addElseStatement((StatementNode) visit(statement));
				}
			}
		}
		return ifElse;
	}
	
	public WhileNode visitWhileStat(WhileStatContext ctx) {
		WhileNode whileNode = new WhileNode();
		whileNode.setCondition((ExpressionNode) visit(ctx.expr()));
		if (ctx.stat().scopeStat() == null) {
			whileNode.addStatement((StatementNode) visit(ctx.stat()));
		} else {
			for (StatContext statement : ctx.stat().scopeStat().stat()) {
				whileNode.addStatement((StatementNode) visit(statement));
			}
		}
		return whileNode;
	}
	
	public DoWhileNode visitDoWhileStat(DoWhileStatContext ctx) {
		DoWhileNode doWhileNode = new DoWhileNode();
		doWhileNode.setCondition((ExpressionNode) visit(ctx.expr()));
		if (ctx.stat().scopeStat() == null) {
			doWhileNode.addStatement((StatementNode) visit(ctx.stat()));
		} else {
			for (StatContext statement : ctx.stat().scopeStat().stat()) {
				doWhileNode.addStatement((StatementNode) visit(statement));
			}
		}
		return doWhileNode;
	}
	
	public ReturnNode visitReturnStat(ReturnStatContext ctx) {
		ReturnNode returnNode = new ReturnNode();
		if (ctx.expr() != null) {
			returnNode.setValue((ExpressionNode) visit(ctx.expr()));
		}
		return returnNode;
	}
	
	public BreakNode visitBreakStat(BreakStatContext ctx) {
		return new BreakNode();
	}
	
	public ContinueNode visitContinueStat(ContinueStatContext ctx) {
		return new ContinueNode();
	}
	
	public ExpressionStatementNode visitExprStat(ExprStatContext ctx) {
		ExpressionStatementNode statement = new ExpressionStatementNode();
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
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitAndExpr(AndExprContext ctx) {
		BinaryExpressionNode binary = new AndExpressionNode();
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public BinaryExpressionNode visitOrExpr(OrExprContext ctx) {
		BinaryExpressionNode binary = new OrExpressionNode();
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}
	
	public AssignmentNode visitAssignExpr(AssignExprContext ctx) {
		AssignmentNode assignment = new AssignmentNode();
		assignment.setVariableName(ctx.ID().getText());
		assignment.setExpression((ExpressionNode) visit(ctx.expr()));
		return assignment;
	}
	
	public Node visitParenExpr(ParenExprContext ctx) {
		return visit(ctx.expr());
	}
	
	public VariableNode visitVariable(VariableContext ctx) {
		VariableNode variable = new VariableNode();
		variable.setName(ctx.ID().getText());
		return variable;
	}
	
	public ConstantNode visitConstant(ConstantContext ctx) {
		ConstantNode constant = new ConstantNode();
		if (ctx.constantExpr().NUM() != null) {
			constant.setType(Type.NUM);
			constant.setValue(ctx.constantExpr().NUM().getText());
		} else if (ctx.constantExpr().STR() != null) {
			constant.setType(Type.STR);
			constant.setValue(ctx.constantExpr().NUM().getText().replace("\"", ""));
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
		functionCall.setName(ctx.ID().toString());
		if (ctx.functionArgs() != null) {
			for (ExprContext arg : ctx.functionArgs().expr()) {
				functionCall.addArgument((ExpressionNode) visit(arg));
			}
		}
		return functionCall;
	}
}

package com.semkagtn.tree;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.semkagtn.generated.JavascripticBaseVisitor;
import com.semkagtn.generated.JavascripticParser;

public class AstBuilder extends JavascripticBaseVisitor<Node> {
	private Node root;
	private final String fileName;
	
	public AstBuilder(String fileName) {
		this.fileName = fileName;
	}
	
	public ProgramNode visitProgram(JavascripticParser.ProgramContext ctx) {
		ProgramNode program = new ProgramNode();
		program.setProgramName(fileName);
		if (ctx.block().stat() != null) {
			for (JavascripticParser.StatContext statement : ctx.block().stat()) {
				program.addStatement((StatementNode) visit(statement));
			}
		}
		root = program;
		return program;
	}
	
	public Node visitStat(JavascripticParser.StatContext ctx) {
		return visitChildren(ctx);
	}
	
	public ScopeNode visitScopeStat(JavascripticParser.ScopeStatContext ctx) {
		ScopeNode scope = new ScopeNode();
		for (JavascripticParser.StatContext statement : ctx.block().stat()) {
			scope.addStatement((StatementNode) visit(statement));
		}
		return scope;
	}
	
	public FunctionNode visitFunctionDecl(JavascripticParser.FunctionDeclContext ctx) {
		FunctionNode function = new FunctionNode();
		function.setName(ctx.ID().toString());
		if (ctx.functionParams() != null) {
			for (TerminalNode p : ctx.functionParams().ID()) {
				FunctionParameterNode parameter = new FunctionParameterNode();
				parameter.setName(p.getText());
				function.addParameter(parameter);
			}
		}
		if (ctx.scopeStat().block().stat() != null) {
			for (JavascripticParser.StatContext statement : ctx.scopeStat().block().stat()) {
				function.addStatement((StatementNode) visit(statement));
			}
		}
		return function;
	}
	
	public VariableDeclarationNode visitVarDecl(JavascripticParser.VarDeclContext ctx) {
		VariableNode variable = new VariableNode();
		variable.setName(ctx.ID().getText());
		VariableDeclarationNode varDecl = new VariableDeclarationNode();
		varDecl.setVariable(variable);
		if (ctx.expr() != null) {
			varDecl.setInitialValue((ExpressionNode) visit(ctx.expr()));
		}
		return varDecl;
	}
	
	public AssignmentNode visitAssign(JavascripticParser.AssignContext ctx) {
		VariableNode variable = new VariableNode();
		variable.setName(ctx.ID().getText());
		AssignmentNode assign = new AssignmentNode();
		assign.setExpression((ExpressionNode) visit(ctx.expr()));
		return assign;
	}
	
	public IfElseNode visitIfStat(JavascripticParser.IfStatContext ctx) {
		IfElseNode ifElse = new IfElseNode();
		ifElse.setCondition((ExpressionNode) visit(ctx.expr()));
		if (ctx.stat().get(0).scopeStat() != null) {
			if (ctx.stat().get(0).scopeStat().block().stat() != null) {
				for (JavascripticParser.StatContext statement : ctx.stat().get(0).scopeStat().block().stat()) {
					ifElse.addIfStatement((StatementNode) visit(statement));
				}
			}
		} else {
			ifElse.addIfStatement((StatementNode) visit(ctx.stat().get(0)));
		}
		if (ctx.stat().size() > 1) {
			if (ctx.stat().get(1).scopeStat() != null) {
				if (ctx.stat().get(1).scopeStat().block().stat() != null) {
					for (JavascripticParser.StatContext statement : ctx.stat().get(1).scopeStat().block().stat()) {
						ifElse.addElseStatement((StatementNode) visit(statement));
					}
				}
			} else {
				ifElse.addElseStatement((StatementNode) visit(ctx.stat().get(0)));
			}
		}
		return ifElse;
	}
	
	public WhileNode visitWhileStat(JavascripticParser.WhileStatContext ctx) {
		WhileNode whileStatement = new WhileNode();
		whileStatement.setCondition((ExpressionNode) visit(ctx.expr()));
		if (ctx.stat().scopeStat() != null) {
			for (JavascripticParser.StatContext statement : ctx.stat().scopeStat().block().stat()) {
				whileStatement.addStatement((StatementNode) visit(statement));
			}
		} else {
			whileStatement.addStatement((StatementNode) visit(ctx.stat()));
		}
		return whileStatement;
	}
	
	public DoWhileNode visitDoWhileStat(JavascripticParser.DoWhileStatContext ctx) {
		DoWhileNode doWhile = new DoWhileNode();
		doWhile.setCondition((ExpressionNode) visit(ctx.expr()));
		if (ctx.stat().scopeStat() != null) {
			for (JavascripticParser.StatContext statement : ctx.stat().scopeStat().block().stat()) {
				doWhile.addStatement((StatementNode) visit(statement));
			}
		} else {
			doWhile.addStatement((StatementNode) visit(ctx.stat()));
		}
		return doWhile;
	}
	
	public ReturnNode visitReturnStat(JavascripticParser.ReturnStatContext ctx) {
		ReturnNode returnStatement = new ReturnNode();
		returnStatement.setValue((ExpressionNode) visit(ctx.expr()));
		return returnStatement;
	}
	
	/*public BreakNode visitBreakStat(JavascripticParser.BreakStatContext ctx) {
		return new BreakNode();
	}*/
	
	public UnaryExpressionNode visitUnaryExpr(JavascripticParser.UnaryExprContext ctx) {
		UnaryExpressionNode result;
		if (ctx.op.getType() == JavascripticParser.NOT) {
			result = new NotExpressionNode();
		} else {
			result = new NegExpressionNode();
		}
		result.setExpression((ExpressionNode) visit(ctx.expr()));
		return result;
	}
	
	public BinaryExpressionNode visitMulDivModExpr(JavascripticParser.MulDivModExprContext ctx) {
		BinaryExpressionNode result;
		if (ctx.op.getType() == JavascripticParser.MUL) {
			result = new MulExpressionNode();
		} else if (ctx.op.getType() == JavascripticParser.DIV) {
			result = new DivExpressionNode();
		} else {
			result = new ModExpressionNode();
		}
		result.setLhs((ExpressionNode) visit(ctx.expr().get(0)));
		result.setRhs((ExpressionNode) visit(ctx.expr().get(1)));
		return result;
	}
	
	public BinaryExpressionNode visitAddSub(JavascripticParser.AddSubExprContext ctx) {
		BinaryExpressionNode result;
		if (ctx.op.getType() == JavascripticParser.ADD) {
			result = new AddExpressionNode();
		} else {
			result = new SubExpressionNode();
		}
		result.setLhs((ExpressionNode) visit(ctx.expr().get(0)));
		result.setRhs((ExpressionNode) visit(ctx.expr().get(1)));
		return result;
	}
	
	public BinaryExpressionNode visitCmpExpr(JavascripticParser.CmpExprContext ctx) {
		BinaryExpressionNode result;
		if (ctx.op.getType() == JavascripticParser.LT) {
			result = new LtExpressionNode();
		} else if (ctx.op.getType() == JavascripticParser.LQ) {
			result = new LeExpressionNode();
		} else if (ctx.op.getType() == JavascripticParser.GT) {
			result = new GtExpressionNode();
		} else {
			result = new GeExpressionNode();
		}
		result.setLhs((ExpressionNode) visit(ctx.expr().get(0)));
		result.setRhs((ExpressionNode) visit(ctx.expr().get(1)));
		return result;
	}
	
	public BinaryExpressionNode visitEqExpr(JavascripticParser.EqExprContext ctx) {
		BinaryExpressionNode result;
		if (ctx.op.getType() == JavascripticParser.EQ) {
			result = new EqExpressionNode();
		} else {
			result = new NeExpressionNode();
		}
		result.setLhs((ExpressionNode) visit(ctx.expr().get(0)));
		result.setRhs((ExpressionNode) visit(ctx.expr().get(1)));
		return result;
	}
	
	public AndExpressionNode visitAndExpr(JavascripticParser.AndExprContext ctx) {
		AndExpressionNode result = new AndExpressionNode();
		result.setLhs((ExpressionNode) visit(ctx.expr().get(0)));
		result.setRhs((ExpressionNode) visit(ctx.expr().get(1)));
		return result;
	}
	
	public OrExpressionNode visitOrExpr(JavascripticParser.OrExprContext ctx) {
		OrExpressionNode result = new OrExpressionNode();
		result.setLhs((ExpressionNode) visit(ctx.expr().get(0)));
		result.setRhs((ExpressionNode) visit(ctx.expr().get(1)));
		return result;
	}
	
	public Node visitParenExpr(JavascripticParser.ParenExprContext ctx) {
		return visitChildren(ctx);
	}
	
	public VariableNode visitId(JavascripticParser.IdContext ctx) {
		VariableNode variable = new VariableNode();
		variable.setName(ctx.ID().getText());
		return variable;
	}
	
	/*public ConstantNode visitConstant(JavascripticParser.ConstantContext ctx) {
		
	}*/
	
	public FunctionCallNode visitFunctionCallExpr(JavascripticParser.FunctionCallExprContext ctx) {
		FunctionCallNode function = new FunctionCallNode();
		function.setName(ctx.functionCall().ID().getText());
		if (ctx.functionCall().functionArgs() != null) {
			for (JavascripticParser.ExprContext expr : ctx.functionCall().functionArgs().expr()) {
				function.addArgument((ExpressionNode) visit(expr));
			}
		}
		return function;
	}
	// to be continue...
}

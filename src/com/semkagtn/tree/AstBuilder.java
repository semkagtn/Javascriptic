package com.semkagtn.tree;

import com.semkagtn.generated.JavascripticBaseVisitor;
import com.semkagtn.generated.JavascripticParser.AssignContext;
import com.semkagtn.generated.JavascripticParser.BreakStatContext;
import com.semkagtn.generated.JavascripticParser.ContinueStatContext;
import com.semkagtn.generated.JavascripticParser.DoWhileStatContext;
import com.semkagtn.generated.JavascripticParser.ExprContext;
import com.semkagtn.generated.JavascripticParser.ExprStatContext;
import com.semkagtn.generated.JavascripticParser.FunctionDeclContext;
import com.semkagtn.generated.JavascripticParser.IfStatContext;
import com.semkagtn.generated.JavascripticParser.ParamContext;
import com.semkagtn.generated.JavascripticParser.ProgramContext;
import com.semkagtn.generated.JavascripticParser.ReturnStatContext;
import com.semkagtn.generated.JavascripticParser.ScopeStatContext;
import com.semkagtn.generated.JavascripticParser.StatContext;
import com.semkagtn.generated.JavascripticParser.VarDeclContext;
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
}

package com.semkagtn.javascriptic.visitor;

import com.semkagtn.javascriptic.JavascripticBaseVisitor;
import com.semkagtn.javascriptic.JavascripticParser;
import com.semkagtn.javascriptic.tree.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

public class AstBuilder extends JavascripticBaseVisitor<AstNode> {
	private Stack<FunctionNode> scopes;
	
	public AstBuilder() {
		scopes = new Stack<>();
	}

    @Override
	public AstNode visitProgram(JavascripticParser.ProgramContext ctx) {
		ProgramNode program = new ProgramNode();
		scopes.push(program);
		program.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		for (JavascripticParser.StatContext stat : ctx.stat()) {
			program.addStatement((StatementNode) visit(stat));
		}
		scopes.pop();
		return program;
	}

    @Override
	public AstNode visitStat(JavascripticParser.StatContext ctx) {
		return visitChildren(ctx);
	}

    @Override
	public AstNode visitBlockStat(JavascripticParser.BlockStatContext ctx) {
		BlockNode block = new BlockNode();
		block.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		for (JavascripticParser.StatContext stat : ctx.stat()) {
			block.addStatement((StatementNode) visit(stat));
		}
		return block;
	}

    @Override
	public AstNode visitVarDeclStat(JavascripticParser.VarDeclStatContext ctx) {
		AssignmentNode assign = new AssignmentNode();
		assign.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		VarNode var = new VarNode();
		var.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		var.setName(ctx.ID().getText());
		assign.setVariable(var);
		scopes.peek().addVariable(var.getName());
		if (ctx.expr() != null) {
			assign.setExpression((ExpressionNode) visit(ctx.expr()));
		} else {
			assign.setExpression(var);
		}
		ExpressionStatementNode exprStat = new ExpressionStatementNode();
		exprStat.setExpression(assign);
		return exprStat;
	}

    @Override
	public AstNode visitIfStat(JavascripticParser.IfStatContext ctx) {
		IfElseNode ifElse = new IfElseNode();
		ifElse.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		ifElse.setCondition((ExpressionNode) visit(ctx.expr()));
		ifElse.setIfStatement((StatementNode) visit(ctx.stat(0)));
		if (ctx.stat(1) != null) {
			ifElse.setElseStatement((StatementNode) visit(ctx.stat(1)));
		}
		return ifElse;
	}

    @Override
	public AstNode visitWhileStat(JavascripticParser.WhileStatContext ctx) {
		WhileNode whileNode = new WhileNode();
		whileNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		whileNode.setCondition((ExpressionNode) visit(ctx.expr()));
		whileNode.setStatement((StatementNode) visit(ctx.stat()));
		return whileNode;
	}

    @Override
	public AstNode visitReturnStat(JavascripticParser.ReturnStatContext ctx) {
		ReturnNode returnNode = new ReturnNode();
		returnNode.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		if (ctx.expr() != null) {
			returnNode.setValue((ExpressionNode) visit(ctx.expr()));
		}
		return returnNode;
	}

    @Override
	public AstNode visitExprStat(JavascripticParser.ExprStatContext ctx) {
		ExpressionStatementNode statement = new ExpressionStatementNode();
		statement.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		statement.setExpression((ExpressionNode) visit(ctx.expr()));
		return statement;
	}

    @Override
	public AstNode visitParens(JavascripticParser.ParensContext ctx) {
		return visit(ctx.expr());
	}

    @Override
	public AstNode visitFunctionCall(JavascripticParser.FunctionCallContext ctx) {
		FunctionCallNode functionCall = new FunctionCallNode();
		functionCall.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		functionCall.setFunction((ExpressionNode) visit(ctx.expr()));
		if (ctx.functionArgs() != null) {
			for (JavascripticParser.ExprContext arg : ctx.functionArgs().expr()) {
				functionCall.addArgument((ExpressionNode) visit(arg));
			}
		}
		return functionCall;
	}

    @Override
	public AstNode visitUnaryExpr(JavascripticParser.UnaryExprContext ctx) {
		UnaryExpressionNode unary;
		if (ctx.op.getType() == JavascripticParser.NOT) {
			unary = new NotNode();
		} else if (ctx.op.getType() == JavascripticParser.MINUS) {
			unary = new NegNode();
		} else {
			unary = new PlusNode();
		}
		unary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		unary.setExpression((ExpressionNode) visit(ctx.expr()));
		return unary;
	}

    @Override
	public AstNode visitMulDivMod(JavascripticParser.MulDivModContext ctx) {
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

    @Override
	public AstNode visitAddSub(JavascripticParser.AddSubContext ctx) {
		BinaryExpressionNode binary;
		if (ctx.op.getType() == JavascripticParser.PLUS) {
			binary = new AddNode();
		} else {
			binary = new SubNode();
		}
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}

    @Override
	public AstNode visitCmp(JavascripticParser.CmpContext ctx) {
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

    @Override
	public AstNode visitEq(JavascripticParser.EqContext ctx) {
		BinaryExpressionNode binary;
		if (ctx.op.getType() == JavascripticParser.EQ) {
			binary = new EqNode();
		} else if (ctx.op.getType() == JavascripticParser.NE) {
			binary = new NeNode();
		} else if (ctx.op.getType() == JavascripticParser.SEQ) {
			binary = new StrictEqNode();
		} else {
			binary = new StrictNeNode();
		}
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}

    @Override
	public AstNode visitAnd(JavascripticParser.AndContext ctx) {
		BinaryExpressionNode binary = new AndNode();
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}

    @Override
	public AstNode visitOr(JavascripticParser.OrContext ctx) {
		BinaryExpressionNode binary = new OrNode();
		binary.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		binary.setLhs((ExpressionNode) visit(ctx.expr(0)));
		binary.setRhs((ExpressionNode) visit(ctx.expr(1)));
		return binary;
	}

    @Override
	public AstNode visitAssign(JavascripticParser.AssignContext ctx) {
		AssignmentNode assignment = new AssignmentNode();
		assignment.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		VarNode var = new VarNode();
		var.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		var.setName(ctx.ID().getText());
		assignment.setVariable(var);
		assignment.setExpression((ExpressionNode) visit(ctx.expr()));
		return assignment;
	}

    @Override
	public AstNode visitVar(JavascripticParser.VarContext ctx) {
		VarNode variable = new VarNode();
		variable.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		variable.setName(ctx.ID().getText());
		return variable;
	}

    @Override
	public AstNode visitConstant(JavascripticParser.ConstantContext ctx) {
		ConstantNode constant;
		if (ctx.NUM() != null) {
			constant = new NumberNode();
			constant.setValue(ctx.NUM().getText());
		} else if (ctx.STR() != null) {
			constant = new StringNode();
			constant.setValue(ctx.STR().getText());
		} else if (ctx.BOOL() != null) {
			constant = new BoolNode();
			constant.setValue(ctx.BOOL().getText());
		} else {
			constant = new UndefNode();
			constant.setValue(ctx.UNDEF().getText());
		}
		constant.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		return constant;
	}

    @Override
	public AstNode visitFunction(JavascripticParser.FunctionContext ctx) {
		FunctionNode function = new FunctionNode();
		scopes.push(function);
		function.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		function.setValue(ctx.getText()); // No pretty-printing :(
		if (ctx.functionParams() != null) {
			for (TerminalNode paramName : ctx.functionParams().ID()) {
				FunctionParameterNode param = new FunctionParameterNode();
				param.setName(paramName.getText());
				scopes.peek().addVariable(param.getName());
				function.addParameter(param);
			}
		}
		for (JavascripticParser.StatContext statement : ctx.blockStat().stat()) {
			function.addStatement((StatementNode) visit(statement)); 
		}
		scopes.pop();
		return function;
	}

    @Override
	public AstNode visitArray(JavascripticParser.ArrayContext ctx) {
		ArrayNode array = new ArrayNode();
		if (ctx.functionArgs() != null) {
			for (JavascripticParser.ExprContext elem : ctx.functionArgs().expr()) {
				array.addElement((ExpressionNode) visit(elem));
			}
		}
		return array;
	}

    @Override
	public AstNode visitGetField(JavascripticParser.GetFieldContext ctx) {
		GetFieldNode getIndex = new GetFieldNode();
		getIndex.setVariable((ExpressionNode) visit(ctx.expr()));
		if (ctx.index() != null) {
			getIndex.setIndex((ExpressionNode) visit(ctx.index().expr()));
		} else if (ctx.field() != null) {
			StringNode str = new StringNode();
			str.setValue("'" + ctx.field().ID().getText() + "'");
			getIndex.setIndex(str);
		}
		return getIndex;
	}

    @Override
	public AstNode visitPutField(JavascripticParser.PutFieldContext ctx) {
		PutFieldNode putIndex = new PutFieldNode();
		putIndex.setVariable((ExpressionNode) visit(ctx.expr(0)));
		if (ctx.index() != null) {
			putIndex.setIndex((ExpressionNode) visit(ctx.index().expr()));
		} else if (ctx.field() != null) {
			StringNode str = new StringNode();
			str.setValue("'" + ctx.field().ID().getText() + "'");
			putIndex.setIndex(str);
		}
		putIndex.setExpression((ExpressionNode) visit(ctx.expr(1)));
		return putIndex;
	}

    @Override
	public AstNode visitDoWhileStat(JavascripticParser.DoWhileStatContext ctx) {
		DoWhileNode doWhile = new DoWhileNode();
		doWhile.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		doWhile.setCondition((ExpressionNode) visit(ctx.expr()));
		doWhile.setStatement((StatementNode) visit(ctx.stat()));
		return doWhile;
	}
}

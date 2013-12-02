package com.semkagtn.javascriptic.visitor;

import java.util.Stack;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.semkagtn.javascriptic.generated.JavascripticBaseVisitor;
import com.semkagtn.javascriptic.generated.JavascripticParser;
import com.semkagtn.javascriptic.generated.JavascripticParser.AddSubContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.AndContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.ArrayContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.AssignContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.BlockStatContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.CmpContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.ConstantContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.EqContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.ExprContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.ExprStatContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.FunctionCallContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.FunctionContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.GetIndexContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.IfStatContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.MulDivModContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.OrContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.ParensContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.ProgramContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.PutIndexContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.ReturnStatContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.StatContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.UnaryExprContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.VarContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.VarDeclStatContext;
import com.semkagtn.javascriptic.generated.JavascripticParser.WhileStatContext;
import com.semkagtn.javascriptic.tree.AddNode;
import com.semkagtn.javascriptic.tree.AndNode;
import com.semkagtn.javascriptic.tree.ArrayNode;
import com.semkagtn.javascriptic.tree.AssignmentNode;
import com.semkagtn.javascriptic.tree.AstNode;
import com.semkagtn.javascriptic.tree.BinaryExpressionNode;
import com.semkagtn.javascriptic.tree.BlockNode;
import com.semkagtn.javascriptic.tree.BoolNode;
import com.semkagtn.javascriptic.tree.ConstantNode;
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
import com.semkagtn.javascriptic.tree.UnaryExpressionNode;
import com.semkagtn.javascriptic.tree.UndefNode;
import com.semkagtn.javascriptic.tree.VarNode;
import com.semkagtn.javascriptic.tree.WhileNode;

public class AstBuilder extends JavascripticBaseVisitor<AstNode> {
	private Stack<FunctionNode> scopes;
	
	public AstBuilder() {
		scopes = new Stack<>();
	}
	
	public ProgramNode visitProgram(ProgramContext ctx) {
		ProgramNode program = new ProgramNode();
		scopes.push(program);
		program.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		for (StatContext stat : ctx.stat()) {
			program.addStatement((StatementNode) visit(stat));
		}
		scopes.pop();
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
	
	public ExpressionStatementNode visitVarDeclStat(VarDeclStatContext ctx) {
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
		} else if (ctx.op.getType() == JavascripticParser.NE) {
			binary = new NeNode();
		} else if (ctx.op.getType() == JavascripticParser.SEQ) {
			binary = new NeNode();
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
		VarNode var = new VarNode();
		var.setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
		var.setName(ctx.ID().getText());
		assignment.setVariable(var);
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
	
	public FunctionNode visitFunction(FunctionContext ctx) {
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
		for (StatContext statement : ctx.blockStat().stat()) {
			function.addStatement((StatementNode) visit(statement)); 
		}
		scopes.pop();
		return function;
	}
	
	public ArrayNode visitArray(ArrayContext ctx) {
		ArrayNode array = new ArrayNode();
		if (ctx.functionArgs() != null) {
			for (ExprContext elem : ctx.functionArgs().expr()) {
				array.addElement((ExpressionNode) visit(elem));
			}
		}
		return array;
	}
	
	public GetIndexNode visitGetIndex(GetIndexContext ctx) {
		GetIndexNode getIndex = new GetIndexNode();
		getIndex.setVariable((ExpressionNode) visit(ctx.expr()));
		getIndex.setIndex((ExpressionNode) visit(ctx.index().expr()));
		return getIndex;
	}
	
	public PutIndexNode visitPutIndex(PutIndexContext ctx) {
		PutIndexNode putIndex = new PutIndexNode();
		putIndex.setVariable((ExpressionNode) visit(ctx.expr(0)));
		putIndex.setIndex((ExpressionNode) visit(ctx.index().expr()));
		putIndex.setExpression((ExpressionNode) visit(ctx.expr(1)));
		return putIndex;
	}
}

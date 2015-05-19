package com.semkagtn.javascriptic.compiler.visitor;

import com.semkagtn.javascriptic.compiler.tree.*;

import java.util.LinkedList;


public class Checker implements AstVisitor<Object> {
	private int functionCount; // for checking return statements
	private LinkedList<FunctionNode> scopes; // for checking variable declarations
	
	private boolean findVariable(String name) {
		for (String f : LIBRARY) {
			if (f.equals(name)) {
				return true;
			}
		}
		for (FunctionNode scope : scopes) {
			if (scope.findVariable(name)) {
				return true;
			}
		}
		return false;
	}
	
	private void visitUnary(UnaryExpressionNode expr) {
		expr.getExpression().accept(this);
	}
	
	private void visitBinary(BinaryExpressionNode expr) {
		expr.getLhs().accept(this);
		expr.getRhs().accept(this);	
	}
	
	public Checker() {
		functionCount = 0;
		scopes = new LinkedList<>();
	}

    @Override
	public Object visit(ProgramNode program) {
		scopes.push(program); // global variables
		for (StatementNode stat : program.getBody()) {
			stat.accept(this);
		}
		scopes.pop();
		return null;
	}

    @Override
	public Object visit(BlockNode block) {
		for (StatementNode stat : block.getBody()) {
			stat.accept(this);
		}
		return null;
	}

    @Override
	public Object visit(VarNode var) {
		if (findVariable(var.getName())) {
			return null;
		}
		ErrorHandler.notDefined(var.getPosition(), var.getName());
		return null;
	}

    @Override
	public Object visit(IfElseNode ifElse) {
		ifElse.getCondition().accept(this);
		ifElse.getIfStatement().accept(this);
		if (ifElse.getElseStatement() != null) {
			ifElse.getElseStatement().accept(this);
		}
		return null;
	}

    @Override
	public Object visit(WhileNode whileStat) {
		whileStat.getCondition().accept(this);
		whileStat.getStatement().accept(this);
		return null;
	}

    @Override
	public Object visit(DoWhileNode doWhile) {
		doWhile.getCondition().accept(this);
		doWhile.getStatement().accept(this);
		return null;
	}

    @Override
	public Object visit(FunctionCallNode functionCall) {
		functionCall.getFunction().accept(this);
		for (ExpressionNode expr : functionCall.getArguments()) {
			expr.accept(this);
		}
		return null;
	}

    @Override
	public Object visit(ReturnNode returnStat) {
		if (functionCount == 0) {
			ErrorHandler.returnNotInFunction(returnStat.getPosition());
		}
		if (returnStat.getValue() != null) {
			returnStat.getValue().accept(this);
		}
		return null;
	}

    @Override
	public Object visit(FunctionParameterNode functionParam) {
		return null;
	}

    @Override
	public Object visit(NotNode not) {
		visitUnary(not);
		return null;
	}

    @Override
	public Object visit(NegNode negation) {
		visitUnary(negation);
		return null;
	}

    @Override
	public Object visit(AddNode add) {
		visitBinary(add);
		return null;
	}

    @Override
	public Object visit(SubNode sub) {
		visitBinary(sub);
		return null;
	}

    @Override
	public Object visit(MulNode mul) {
		visitBinary(mul);
		return null;
	}

    @Override
	public Object visit(DivNode div) {
		visitBinary(div);
		return null;
	}

    @Override
	public Object visit(ModNode mod) {
		visitBinary(mod);
		return null;
	}

    @Override
	public Object visit(LtNode lt) {
		visitBinary(lt);
		return null;
	}

    @Override
	public Object visit(LeNode le) {
		visitBinary(le);
		return null;
	}

    @Override
	public Object visit(GtNode gt) {
		visitBinary(gt);
		return null;
	}

    @Override
	public Object visit(GeNode ge) {
		visitBinary(ge);
		return null;
	}

    @Override
	public Object visit(EqNode eq) {
		visitBinary(eq);
		return null;
	}

    @Override
	public Object visit(NeNode ne) {
		visitBinary(ne);
		return null;
	}

    @Override
	public Object visit(AndNode and) {
		visitBinary(and);
		return null;
	}

    @Override
	public Object visit(OrNode or) {
		visitBinary(or);
		return null;
	}

    @Override
	public Object visit(ExpressionStatementNode exprStat) {
		exprStat.getExpression().accept(this);
		return null;
	}

    @Override
	public Object visit(AssignmentNode assign) {
		assign.getExpression().accept(this);
		assign.getVariable().accept(this);
		return null;
	}

    @Override
	public Object visit(FunctionNode function) {
		++functionCount;
		scopes.push(function);
		for (FunctionParameterNode param : function.getParameters()) {
			param.accept(this);
		}
		for (StatementNode stat : function.getBody()) {
			stat.accept(this);
		}
		scopes.pop();
		--functionCount;
		return null;
	}

    @Override
	public Object visit(BoolNode bool) {
		return null;
	}

    @Override
	public Object visit(NumberNode number) {
		return null;
	}

    @Override
	public Object visit(StringNode string) {
		return null;
	}

    @Override
	public Object visit(UndefNode undef) {
		return null;
	}

    @Override
	public Object visit(ArrayNode array) {
		for (ExpressionNode elem : array.getElements()) {
			elem.accept(this);
		}
		return null;
	}

    @Override
	public Object visit(GetFieldNode getIndex) {
		getIndex.getVariable().accept(this);
		getIndex.getIndex().accept(this);
		return null;
	}

    @Override
	public Object visit(PutFieldNode putIndex) {
		putIndex.getVariable().accept(this);
		putIndex.getIndex().accept(this);
		putIndex.getExpression().accept(this);
		return null;
	}

    @Override
	public Object visit(StrictEqNode eq) {
		visitBinary(eq);
		return null;
	}

    @Override
	public Object visit(StrictNeNode ne) {
		visitBinary(ne);
		return null;
	}

    @Override
	public Object visit(PlusNode plus) {
		visitUnary(plus);
		return null;
	}
}

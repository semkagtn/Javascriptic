package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class IfElseNode extends StatementNode {
	private ExpressionNode condition;
	private StatementNode ifStatement;
	private StatementNode elseStatement;
	
	public IfElseNode() {
		condition = null;
		ifStatement = null;
		elseStatement = null;
	}
	
	public ExpressionNode getCondition() {
		return condition;
	}
	
	public void setCondition(ExpressionNode condition) {
		this.condition = condition;
	}
	
	public StatementNode getIfStatement() {
		return ifStatement;
	}
	
	public void setIfStatement(StatementNode statement) {
		ifStatement = statement;
	}
	
	public StatementNode getElseStatement() {
		return elseStatement;
	}
	
	public void setElseStatement(StatementNode statement) {
		elseStatement = statement;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

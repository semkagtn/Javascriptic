package com.semkagtn.javascriptic.compiler.tree;

import com.semkagtn.javascriptic.compiler.visitor.AstVisitor;

public class WhileNode extends StatementNode {
	private ExpressionNode condition;
	private StatementNode statement;

	public WhileNode() {
		condition = null;
		statement = null;
	}
	
	public StatementNode getStatement() {
		return statement;
	}
	
	public void setStatement(StatementNode statement) {
		this.statement = statement;
	}	
	
	public ExpressionNode getCondition() {
		return condition;
	}
	
	public void setCondition(ExpressionNode condition) {
		this.condition = condition;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

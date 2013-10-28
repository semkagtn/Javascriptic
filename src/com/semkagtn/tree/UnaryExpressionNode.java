package com.semkagtn.tree;

public abstract class UnaryExpressionNode extends ExpressionNode {
	private ExpressionNode expression;
	
	public UnaryExpressionNode() {
		expression = null;
	}
	
	public ExpressionNode getExpression() {
		return expression;
	}
	
	public void setExpression(ExpressionNode expression) {
		this.expression = expression;
	}
}

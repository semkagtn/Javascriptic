package com.semkagtn.tree;

public abstract class BinaryExpressionNode extends ExpressionNode {
	private ExpressionNode lhs;
	private ExpressionNode rhs;
	
	public BinaryExpressionNode() {
		lhs = null;
		rhs = null;
	}
	
	public ExpressionNode getLhs() {
		return lhs;
	}
	
	public void setLhs(ExpressionNode lhs) {
		this.lhs = lhs;
	}
	
	public ExpressionNode getRhs() {
		return rhs;
	}
	
	public void setRhs(ExpressionNode rhs) {
		this.rhs = rhs;
	}
}

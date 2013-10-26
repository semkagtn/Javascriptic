package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class ReturnNode extends ExpressionNode {
	private ExpressionNode value;
	
	public ReturnNode() {
		value = null;
	}
	
	public ExpressionNode getValue() {
		return value;
	}
	
	public void setValue(ExpressionNode value) {
		this.value = value;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

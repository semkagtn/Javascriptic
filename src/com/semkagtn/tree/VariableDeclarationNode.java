package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

// Maybe need to fix

public class VariableDeclarationNode extends StatementNode {
	private String name;
	private ExpressionNode initialValue;
	
	public VariableDeclarationNode() {
		name = "";
		initialValue = null;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ExpressionNode getInitialValue() {
		return initialValue;
	}
	
	public void setInitialValue(ExpressionNode initialValue) {
		this.initialValue = initialValue;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

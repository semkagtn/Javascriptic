package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class VariableDeclarationNode extends StatementNode {
	private VariableNode variable;
	private ExpressionNode initialValue;
	
	public VariableDeclarationNode() {
		variable = null;
		initialValue = null;
	}
	
	public VariableNode getVariable() {
		return variable;
	}
	
	public void setVariable(VariableNode variable) {
		this.variable = variable;
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

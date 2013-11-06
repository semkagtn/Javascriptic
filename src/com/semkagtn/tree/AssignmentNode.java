package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

// Maybe need to fix

public class AssignmentNode extends ExpressionNode {
	private String variableName;
	private ExpressionNode expression;
	
	public AssignmentNode() {
		variableName = "";
		expression = null;
	}
	
	public String getVariableName() {
		return variableName;
	}
	
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	
	public ExpressionNode getExpression() {
		return expression;
	}
	
	public void setExpression(ExpressionNode expression) {
		this.expression = expression;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return null;
	}
}

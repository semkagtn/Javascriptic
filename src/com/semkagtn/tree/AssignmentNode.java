package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class AssignmentNode extends StatementNode {
	private VariableNode variable;
	private ExpressionNode expression;
	
	public AssignmentNode() {
		variable = null;
		expression = null;
	}
	
	public VariableNode getVariable() {
		return variable;
	}
	
	public void setVariable(VariableNode variable) {
		this.variable = variable;
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

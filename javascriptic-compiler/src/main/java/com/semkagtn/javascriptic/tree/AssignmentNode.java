package com.semkagtn.javascriptic.tree;

import com.semkagtn.javascriptic.visitor.AstVisitor;

public class AssignmentNode extends ExpressionNode {
	private VarNode variable;
	private ExpressionNode expression;
	
	public AssignmentNode() {
		variable = null;
		expression = null;
	}
	
	public VarNode getVariable() {
		return variable;
	}
	
	public void setVariable(VarNode variable) {
		this.variable = variable;
	}
	
	public ExpressionNode getExpression() {
		return expression;
	}
	
	public void setExpression(ExpressionNode expression) {
		this.expression = expression;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

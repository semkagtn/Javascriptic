package com.semkagtn.javascriptic.compiler.tree;

import com.semkagtn.javascriptic.compiler.visitor.AstVisitor;

public class PutFieldNode extends ExpressionNode {

	private ExpressionNode variable;
	private ExpressionNode index;
	private ExpressionNode expression;
	
	public PutFieldNode() {
		variable = null;
		index = null;
		expression = null;
	}
	
	public ExpressionNode getVariable() {
		return variable;
	}
	
	public void setVariable(ExpressionNode variable) {
		this.variable = variable;
	}
	
	public ExpressionNode getIndex() {
		return index;
	}
	
	public void setIndex(ExpressionNode index) {
		this.index = index;
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

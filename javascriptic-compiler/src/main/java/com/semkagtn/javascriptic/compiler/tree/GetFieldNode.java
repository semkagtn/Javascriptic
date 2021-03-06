package com.semkagtn.javascriptic.compiler.tree;

import com.semkagtn.javascriptic.compiler.visitor.AstVisitor;

public class GetFieldNode extends ExpressionNode {

	private ExpressionNode variable;
	private ExpressionNode index;
	
	public GetFieldNode() {
		variable = null;
		index = null;
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
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}

}

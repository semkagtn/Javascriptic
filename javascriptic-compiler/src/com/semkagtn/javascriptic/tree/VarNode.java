package com.semkagtn.javascriptic.tree;

import com.semkagtn.javascriptic.visitor.AstVisitor;

public class VarNode extends ExpressionNode {
	private String name;
	private ExpressionNode index;
	
	public VarNode() {
		name = "";
		index = null;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = "_" + name; // for non-conflicting names
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

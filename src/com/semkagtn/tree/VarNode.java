package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class VarNode extends ExpressionNode {
	private String name;
	
	public VarNode() {
		name = "";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

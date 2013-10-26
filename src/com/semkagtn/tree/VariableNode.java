package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class VariableNode extends ValueNode {
	private String name;
	
	public VariableNode() {
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

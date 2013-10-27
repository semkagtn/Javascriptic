package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class ConstantNode extends ValueNode {
	private String value;
	
	public ConstantNode() {
		value = "";
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

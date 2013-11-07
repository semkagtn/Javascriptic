package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class ConstantNode extends ExpressionNode {
	String value;
	Type type;
	
	public ConstantNode() {
		value = "";
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

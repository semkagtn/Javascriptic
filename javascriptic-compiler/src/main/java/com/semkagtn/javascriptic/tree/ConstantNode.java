package com.semkagtn.javascriptic.tree;


public abstract class ConstantNode extends ExpressionNode {
	String value;
	
	public ConstantNode() {
		value = "";
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}

package com.semkagtn.javascriptic.compiler.tree;


import com.semkagtn.javascriptic.runtime.JSObject;

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

    public abstract JSObject toJSObject();
}

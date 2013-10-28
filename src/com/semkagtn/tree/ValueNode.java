package com.semkagtn.tree;

public abstract class ValueNode extends ExpressionNode {
	private Type type;
	
	public ValueNode() {
		type = Type.UNDEF;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
}

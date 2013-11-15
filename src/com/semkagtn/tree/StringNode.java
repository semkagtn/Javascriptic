package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class StringNode extends ConstantNode {
	public void setValue(String value) {
		super.setValue(value.replace("\"", ""));
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

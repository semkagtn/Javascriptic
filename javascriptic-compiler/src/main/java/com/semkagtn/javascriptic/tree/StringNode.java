package com.semkagtn.javascriptic.tree;

import com.semkagtn.javascriptic.visitor.AstVisitor;

public class StringNode extends ConstantNode {
	public void setValue(String value) {
		super.setValue(value
				.substring(1, value.length() - 1)
				.replace("\\\"", "\"")
				.replace("\\\\", "\\")
				.replace("\\b", "\b")
				.replace("\\f", "\f")
				.replace("\\n", "\n")
				.replace("\\r", "\r")
				.replace("\\t", "\t"));
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

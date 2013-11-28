package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class StringNode extends ConstantNode {
	public void setValue(String value) {
		super.setValue(value
				.replace("\"", "")
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

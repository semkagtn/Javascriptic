package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

// Need to fix

public class ConstantNode implements Node {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

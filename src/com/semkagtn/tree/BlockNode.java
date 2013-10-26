package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class BlockNode implements Node {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

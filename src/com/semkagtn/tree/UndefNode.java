package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class UndefNode extends ConstantNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

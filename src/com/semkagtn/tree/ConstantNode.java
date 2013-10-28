package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class ConstantNode extends ValueNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

package com.semkagtn.javascriptic.tree;

import com.semkagtn.javascriptic.visitor.AstVisitor;

public class BoolNode extends ConstantNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

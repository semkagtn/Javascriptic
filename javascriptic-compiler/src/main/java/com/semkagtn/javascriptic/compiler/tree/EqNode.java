package com.semkagtn.javascriptic.compiler.tree;

import com.semkagtn.javascriptic.compiler.visitor.AstVisitor;

public class EqNode extends BinaryExpressionNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}
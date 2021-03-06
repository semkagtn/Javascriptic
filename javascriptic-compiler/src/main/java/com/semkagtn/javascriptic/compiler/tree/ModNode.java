package com.semkagtn.javascriptic.compiler.tree;

import com.semkagtn.javascriptic.compiler.visitor.AstVisitor;

public class ModNode extends BinaryExpressionNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}
package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class DivNode extends BinaryExpressionNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}
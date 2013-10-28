package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class SubExpressionNode extends BinaryExpressionNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}
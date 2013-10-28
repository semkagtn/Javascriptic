package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class NotExpressionNode extends UnaryExpressionNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

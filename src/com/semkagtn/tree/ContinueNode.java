package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class ContinueNode extends StatementNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

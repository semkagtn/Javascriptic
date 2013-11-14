package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class ProgramNode extends BlockNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

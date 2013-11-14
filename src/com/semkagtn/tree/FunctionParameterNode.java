package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class FunctionParameterNode extends VarNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

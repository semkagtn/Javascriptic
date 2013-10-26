package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public interface Node {
	<T> T accept(AstVisitor<T> v);
}

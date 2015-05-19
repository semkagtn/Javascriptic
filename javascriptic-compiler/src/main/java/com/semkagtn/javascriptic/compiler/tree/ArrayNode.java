package com.semkagtn.javascriptic.compiler.tree;

import java.util.ArrayList;

import com.semkagtn.javascriptic.compiler.visitor.AstVisitor;

public class ArrayNode extends ExpressionNode {

	private final ArrayList<ExpressionNode> elements;
	
	public ArrayNode() {
		elements = new ArrayList<>();
	}
	
	public ArrayList<ExpressionNode> getElements() {
		return elements;
	}
	
	public void addElement(ExpressionNode element) {
		elements.add(element);
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}

}

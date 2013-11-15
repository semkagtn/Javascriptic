package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class NumberNode extends ConstantNode {
	public void setValue(String value) {
		try {
			double t = Double.parseDouble(value);
			super.setValue(Double.toString(t));
		} catch (NumberFormatException e) {
			super.setValue(value); // NaN
		}
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

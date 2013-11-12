package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public abstract class Node {
	// position
	private int line;
	private int symbol;
	
	public void setPosition(int line, int symbol) {
		this.line = line;
		this.symbol = symbol;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getSymbol() {
		return symbol;
	}
	
	public abstract <T> T accept(AstVisitor<T> v);
}

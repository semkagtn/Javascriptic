package com.semkagtn.javascriptic.tree;

import com.semkagtn.javascriptic.visitor.AstVisitor;

public abstract class AstNode {
	Position position;
	
	public class Position {
		private int line;
		private int symbol;
		
		public Position(int line, int symbol) {
			this.line = line;
			this.symbol = symbol;
		}
		
		public String toString() {
			return line + ":" + symbol;
		}
	}
	
	public AstNode() {
		position = null;
	}
	
	public void setPosition(int line, int symbol) {
		position = new Position(line, symbol);
	}
	
	public Position getPosition() {
		return position;
	}
	
	public abstract <T> T accept(AstVisitor<T> v);
}

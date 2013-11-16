package com.semkagtn.tree;

import java.util.ArrayList;

import com.semkagtn.visitor.AstVisitor;

public class BlockNode extends StatementNode {
	private final ArrayList<StatementNode> body;
	
	public BlockNode() {
		body = new ArrayList<>();
	}
	
	public ArrayList<StatementNode> getBody() {
		return body;
	}
	
	public void addStatement(StatementNode statement) {
		body.add(statement);
	}	
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

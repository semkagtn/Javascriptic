package com.semkagtn.tree;

import java.util.ArrayList;

import com.semkagtn.visitor.AstVisitor;

public class ScopeNode extends StatementNode {
	private final ArrayList<StatementNode> body;
	
	public ScopeNode() {
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

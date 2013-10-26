package com.semkagtn.tree;

import java.util.ArrayList;

import com.semkagtn.visitor.AstVisitor;

public class WhileNode extends StatementNode {
	private ExpressionNode condition;
	private ArrayList<StatementNode> body;
	
	public WhileNode() {
		condition = null;
		body = new ArrayList<>();
	}
	
	public ExpressionNode getCondition() {
		return condition;
	}
	
	public void setCondition(ExpressionNode condition) {
		this.condition = condition;
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

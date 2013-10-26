package com.semkagtn.tree;

import java.util.ArrayList;

import com.semkagtn.visitor.AstVisitor;

public class IfElseNode extends StatementNode {
	private ExpressionNode condition;
	private final ArrayList<StatementNode> ifBody;
	private final ArrayList<StatementNode> elseBody;
	
	public IfElseNode() {
		condition = null;
		ifBody = new ArrayList<>();
		elseBody = new ArrayList<>();
	}
	
	public ExpressionNode getCondition() {
		return condition;
	}
	
	public void setCondition(ExpressionNode condition) {
		this.condition = condition;
	}
	
	public ArrayList<StatementNode> getIfBody() {
		return ifBody;
	}
	
	public ArrayList<StatementNode> getElseBody() {
		return elseBody;
	}
	
	public void addIfStatement(StatementNode statement) {
		ifBody.add(statement);
	}
	
	public void addElseStatement(StatementNode statement) {
		elseBody.add(statement);
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

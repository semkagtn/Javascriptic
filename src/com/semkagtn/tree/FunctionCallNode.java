package com.semkagtn.tree;

import java.util.ArrayList;

import com.semkagtn.visitor.AstVisitor;

public class FunctionCallNode extends StatementNode {
	private String name;
	private final ArrayList<ExpressionNode> arguments;
	
	public FunctionCallNode() {
		name = "";
		arguments = new ArrayList<ExpressionNode>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<ExpressionNode> getArguments() {
		return arguments;
	}
	
	public void addArgument(ExpressionNode argument) {
		arguments.add(argument);
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

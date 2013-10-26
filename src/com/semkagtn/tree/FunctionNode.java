package com.semkagtn.tree;

import java.util.ArrayList;

import com.semkagtn.visitor.AstVisitor;

public class FunctionNode extends StatementNode {
	private String name;
	private final ArrayList<FunctionParameterNode> parameters;
	private final ArrayList<StatementNode> body;
	
	public FunctionNode() {
		name = "";
		parameters = new ArrayList<>();
		body = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<FunctionParameterNode> getParameters() {
		return parameters;
	}
	
	public void addParameter(FunctionParameterNode parameter) {
		parameters.add(parameter);
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

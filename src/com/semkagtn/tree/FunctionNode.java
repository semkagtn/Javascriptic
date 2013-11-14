package com.semkagtn.tree;

import java.util.ArrayList;

import com.semkagtn.visitor.AstVisitor;


// Anonymous function is a constant!
public class FunctionNode extends ConstantNode {
	private final ArrayList<FunctionParameterNode> parameters;
	private final ArrayList<StatementNode> body;
	
	public FunctionNode() {
		parameters = new ArrayList<>();
		body = new ArrayList<>();
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

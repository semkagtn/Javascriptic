package com.semkagtn.javascriptic.compiler.tree;

import java.util.ArrayList;
import java.util.HashSet;

import com.semkagtn.javascriptic.compiler.visitor.AstVisitor;
import com.semkagtn.javascriptic.runtime.JSFunction;
import com.semkagtn.javascriptic.runtime.JSObject;


public class FunctionNode extends ConstantNode {
	private final ArrayList<FunctionParameterNode> parameters;
	private final ArrayList<StatementNode> body;
	private final HashSet<String> variables;
	
	public FunctionNode() {
		parameters = new ArrayList<>();
		body = new ArrayList<>();
		variables = new HashSet<>();
	}

    @Override
    public JSObject toJSObject() {
        return null;
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
	
	public void addVariable(String name) {
		variables.add(name);
	}
	
	public boolean findVariable(String name) {
		return variables.contains(name);
	}
	
	// debug
	public HashSet<String> getVariables() {
		return variables;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

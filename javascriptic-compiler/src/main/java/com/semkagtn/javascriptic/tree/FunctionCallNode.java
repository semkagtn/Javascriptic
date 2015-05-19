package com.semkagtn.javascriptic.tree;

import java.util.ArrayList;

import com.semkagtn.javascriptic.visitor.AstVisitor;

public class FunctionCallNode extends ExpressionNode {
	private ExpressionNode function;
	private final ArrayList<ExpressionNode> arguments;
	
	public FunctionCallNode() {
		function = null;
		arguments = new ArrayList<ExpressionNode>();
	}
	
	public ExpressionNode getFunction() {
		return function;
	}
	
	public void setFunction(ExpressionNode function) {
		this.function = function;
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

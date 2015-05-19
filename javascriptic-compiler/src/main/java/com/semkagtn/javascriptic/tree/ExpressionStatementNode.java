package com.semkagtn.javascriptic.tree;

import com.semkagtn.javascriptic.visitor.AstVisitor;

// ExprStat : expr ';'
//          ;

public class ExpressionStatementNode extends StatementNode {
	private ExpressionNode expression;
	
	public ExpressionNode getExpression() {
		return expression;
	}
	
	public void setExpression(ExpressionNode expression) {
		this.expression = expression;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

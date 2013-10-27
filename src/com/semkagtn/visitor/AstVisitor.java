package com.semkagtn.visitor;

import com.semkagtn.tree.ConstantNode;
import com.semkagtn.tree.DoWhileNode;
import com.semkagtn.tree.FunctionCallNode;
import com.semkagtn.tree.FunctionNode;
import com.semkagtn.tree.FunctionParameterNode;
import com.semkagtn.tree.IfElseNode;
import com.semkagtn.tree.ProgramNode;
import com.semkagtn.tree.ReturnNode;
import com.semkagtn.tree.ScopeNode;
import com.semkagtn.tree.VariableDeclarationNode;
import com.semkagtn.tree.VariableNode;
import com.semkagtn.tree.WhileNode;

public interface AstVisitor<T> {
	T visit(ProgramNode program);
	T visit(ScopeNode scope);
	T visit(FunctionNode function);
	T visit(VariableDeclarationNode variableDeclaration);
	T visit(VariableNode variable);
	T visit(IfElseNode ifElse);
	T visit(WhileNode whileStatement);
	T visit(DoWhileNode doWhile);
	T visit(FunctionCallNode functionCall);
	T visit(ReturnNode returnStatement);
	T visit(FunctionParameterNode functionParameter);
	T visit(ConstantNode constant);
}
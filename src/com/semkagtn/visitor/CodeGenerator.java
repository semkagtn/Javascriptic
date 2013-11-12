package com.semkagtn.visitor;

import com.semkagtn.tree.AddExpressionNode;
import com.semkagtn.tree.AndExpressionNode;
import com.semkagtn.tree.AssignmentNode;
import com.semkagtn.tree.BreakNode;
import com.semkagtn.tree.ConstantNode;
import com.semkagtn.tree.ContinueNode;
import com.semkagtn.tree.DivExpressionNode;
import com.semkagtn.tree.DoWhileNode;
import com.semkagtn.tree.EqExpressionNode;
import com.semkagtn.tree.ExpressionStatementNode;
import com.semkagtn.tree.FunctionCallNode;
import com.semkagtn.tree.FunctionNode;
import com.semkagtn.tree.FunctionParameterNode;
import com.semkagtn.tree.GeExpressionNode;
import com.semkagtn.tree.GtExpressionNode;
import com.semkagtn.tree.IfElseNode;
import com.semkagtn.tree.LeExpressionNode;
import com.semkagtn.tree.LtExpressionNode;
import com.semkagtn.tree.ModExpressionNode;
import com.semkagtn.tree.MulExpressionNode;
import com.semkagtn.tree.NeExpressionNode;
import com.semkagtn.tree.NegExpressionNode;
import com.semkagtn.tree.NotExpressionNode;
import com.semkagtn.tree.OrExpressionNode;
import com.semkagtn.tree.ProgramNode;
import com.semkagtn.tree.ReturnNode;
import com.semkagtn.tree.ScopeNode;
import com.semkagtn.tree.SubExpressionNode;
import com.semkagtn.tree.VariableDeclarationNode;
import com.semkagtn.tree.VariableNode;
import com.semkagtn.tree.WhileNode;

public class CodeGenerator implements AstVisitor<Object> {

	@Override
	public Object visit(ProgramNode program) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ScopeNode scope) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FunctionNode function) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VariableDeclarationNode variableDeclaration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VariableNode variable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IfElseNode ifElse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WhileNode whileStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DoWhileNode doWhile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FunctionCallNode functionCall) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ReturnNode returnStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FunctionParameterNode functionParameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ConstantNode constant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NotExpressionNode not) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NegExpressionNode negation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AddExpressionNode add) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(SubExpressionNode sub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MulExpressionNode mul) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(DivExpressionNode div) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ModExpressionNode mod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LtExpressionNode lt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LeExpressionNode le) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GtExpressionNode gt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(GeExpressionNode ge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(EqExpressionNode eq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NeExpressionNode ne) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AndExpressionNode and) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(OrExpressionNode or) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(BreakNode breakStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ContinueNode continueNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ExpressionStatementNode exprStat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AssignmentNode assign) {
		// TODO Auto-generated method stub
		return null;
	}
}

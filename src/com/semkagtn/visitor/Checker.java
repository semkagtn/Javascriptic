package com.semkagtn.visitor;

import java.util.LinkedList;
import java.util.Set;

import com.semkagtn.tree.AddExpressionNode;
import com.semkagtn.tree.AndExpressionNode;
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
import com.semkagtn.tree.StatementNode;
import com.semkagtn.tree.SubExpressionNode;
import com.semkagtn.tree.VariableDeclarationNode;
import com.semkagtn.tree.VariableNode;
import com.semkagtn.tree.WhileNode;

public class Checker implements AstVisitor<Object> {
	private int functionCount; // for checking return statements
	private int whileCount; // for checking break and continue statements
	private LinkedList< Set<VariableNode> > scopes; // for checking variable declarations  
	
	public Checker() {
		functionCount = 0;
		whileCount = 0;
		scopes = new LinkedList<>();
	}
	
	public Object visit(ProgramNode program) {
		for (StatementNode stat : program.getBody()) {
			stat.accept(this);
		}
		return null;
	}

	public Object visit(ScopeNode scope) {
		for (StatementNode stat : scope.getBody()) {
			stat.accept(this);
		}
		return null;
	}

	public Object visit(FunctionNode function) {
		++functionCount;
		for (StatementNode stat : function.getBody()) {
			stat.accept(this);
		}
		--functionCount;
		return null;
	}

	public Object visit(VariableDeclarationNode variableDeclaration) {
		return null;
	}

	public Object visit(VariableNode variable) {
		return null;
	}

	public Object visit(IfElseNode ifElse) {
		for (StatementNode stat : ifElse.getIfBody()) {
			stat.accept(this);
		}
		for (StatementNode stat : ifElse.getElseBody()) {
			stat.accept(this);
		}
		return null;
	}

	public Object visit(WhileNode whileStatement) {
		++whileCount;
		for (StatementNode stat : whileStatement.getBody()) {
			stat.accept(this);
		}
		--whileCount;
		return null;
	}

	public Object visit(DoWhileNode doWhile) {
		++whileCount;
		for (StatementNode stat : doWhile.getBody()) {
			stat.accept(this);
		}
		--whileCount;
		return null;
	}

	public Object visit(FunctionCallNode functionCall) {
		return null;
	}

	public Object visit(ReturnNode returnStatement) {
		if (functionCount == 0) {
			System.out.println("return statement not in function");
		}
		return null;
	}

	public Object visit(FunctionParameterNode functionParameter) {
		return null;
	}

	public Object visit(ConstantNode constant) {
		return null;
	}

	public Object visit(NotExpressionNode not) {
		return null;
	}

	public Object visit(NegExpressionNode negation) {
		return null;
	}

	public Object visit(AddExpressionNode add) {
		return null;
	}

	public Object visit(SubExpressionNode sub) {
		return null;
	}

	public Object visit(MulExpressionNode mul) {
		return null;
	}

	public Object visit(DivExpressionNode div) {
		return null;
	}

	public Object visit(ModExpressionNode mod) {
		return null;
	}

	public Object visit(LtExpressionNode lt) {
		return null;
	}

	public Object visit(LeExpressionNode le) {
		return null;
	}

	public Object visit(GtExpressionNode gt) {
		return null;
	}

	public Object visit(GeExpressionNode ge) {
		return null;
	}

	public Object visit(EqExpressionNode eq) {
		return null;
	}

	public Object visit(NeExpressionNode ne) {
		return null;
	}

	public Object visit(AndExpressionNode and) {
		return null;
	}

	public Object visit(OrExpressionNode or) {
		return null;
	}

	public Object visit(BreakNode breakStatement) {
		if (whileCount == 0) {
			System.out.println("break statement not in loop");
		}
		return null;
	}

	public Object visit(ContinueNode continueNode) {
		if (whileCount == 0) {
			System.out.println("continue statement not in loop");
		}
		return null;
	}

	public Object visit(ExpressionStatementNode exprStat) {
		return null;
	}
}

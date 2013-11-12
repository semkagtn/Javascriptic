package com.semkagtn.visitor;

import java.util.HashSet;
import java.util.LinkedList;

import com.semkagtn.tree.AddExpressionNode;
import com.semkagtn.tree.AndExpressionNode;
import com.semkagtn.tree.AssignmentNode;
import com.semkagtn.tree.BinaryExpressionNode;
import com.semkagtn.tree.BreakNode;
import com.semkagtn.tree.ConstantNode;
import com.semkagtn.tree.ContinueNode;
import com.semkagtn.tree.DivExpressionNode;
import com.semkagtn.tree.DoWhileNode;
import com.semkagtn.tree.EqExpressionNode;
import com.semkagtn.tree.ExpressionNode;
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
import com.semkagtn.tree.UnaryExpressionNode;
import com.semkagtn.tree.VariableDeclarationNode;
import com.semkagtn.tree.VariableNode;
import com.semkagtn.tree.WhileNode;

public class Checker implements AstVisitor<Object> {
	private int functionCount; // for checking return statements
	private int loopCount; // for checking break and continue statements
	private LinkedList< HashSet<String> > scopes; // for checking variable declarations  
	
	private boolean findGlobal(String variable) {
		for (HashSet<String> scope : scopes) {
			for (String var : scope) {
				if (variable.equals(var)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean findCurrentScope(String variable) {
		for (String var : scopes.getLast()) {
			if (variable.equals(var)) {
				return true;
			}
		}
		return false;
	}
	
	private void visitUnary(UnaryExpressionNode expr) {
		expr.getExpression().accept(this);
	}
	
	private void visitBinary(BinaryExpressionNode expr) {
		expr.getLhs().accept(this);
		expr.getRhs().accept(this);	
	}
	
	public Checker() {
		functionCount = 0;
		loopCount = 0;
		scopes = new LinkedList<>();
	}
	
	public Object visit(ProgramNode program) {
		scopes.add(new HashSet<String>()); // global variables
		for (StatementNode stat : program.getBody()) {
			stat.accept(this);
		}
		scopes.removeLast();
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
		if (findCurrentScope(function.getName())) {
			System.out.println("Variable " + function.getName() + " already exist");
		}
		scopes.getLast().add(function.getName());
		scopes.add(new HashSet<String>()); // local function variables
		for (FunctionParameterNode param : function.getParameters()) {
			param.accept(this);
		}
		for (StatementNode stat : function.getBody()) {
			stat.accept(this);
		}
		scopes.removeLast();
		--functionCount;
		return null;
	}

	public Object visit(VariableDeclarationNode variableDeclaration) {
		if (variableDeclaration.getInitialValue() != null) {
			variableDeclaration.getInitialValue().accept(this);
		}
		if (findCurrentScope(variableDeclaration.getName())) {
			System.out.println("Variable " + variableDeclaration.getName() + " already exist");
		}
		scopes.getLast().add(variableDeclaration.getName());
		return null;
	}

	public Object visit(VariableNode variable) {
		if (findGlobal(variable.getName())) {
			return null;
		}
		System.out.println("Variable " + variable.getName() + " doesnt exist");
		return null;
	}

	public Object visit(IfElseNode ifElse) {
		ifElse.getCondition().accept(this);
		for (StatementNode stat : ifElse.getIfBody()) {
			stat.accept(this);
		}
		for (StatementNode stat : ifElse.getElseBody()) {
			stat.accept(this);
		}
		return null;
	}

	public Object visit(WhileNode whileStatement) {
		++loopCount;
		whileStatement.getCondition().accept(this);
		for (StatementNode stat : whileStatement.getBody()) {
			stat.accept(this);
		}
		--loopCount;
		return null;
	}

	public Object visit(DoWhileNode doWhile) {
		++loopCount;
		doWhile.getCondition().accept(this);
		for (StatementNode stat : doWhile.getBody()) {
			stat.accept(this);
		}
		--loopCount;
		return null;
	}

	public Object visit(FunctionCallNode functionCall) {
		for (ExpressionNode expr : functionCall.getArguments()) {
			expr.accept(this);
		}
		if (findGlobal(functionCall.getName())) {
			return null;
		}
		System.out.println("Function " + functionCall.getName() + " doesnt exist");
		return null;
	}

	public Object visit(ReturnNode returnStatement) {
		if (functionCount == 0) {
			System.out.println("return statement not in function");
		}
		returnStatement.getValue().accept(this);
		return null;
	}

	public Object visit(FunctionParameterNode functionParameter) {
		scopes.getLast().add(functionParameter.getName());
		return null;
	}

	public Object visit(ConstantNode constant) {
		return null;
	}

	public Object visit(NotExpressionNode not) {
		visitUnary(not);
		return null;
	}

	public Object visit(NegExpressionNode negation) {
		visitUnary(negation);
		return null;
	}

	public Object visit(AddExpressionNode add) {
		visitBinary(add);
		return null;
	}

	public Object visit(SubExpressionNode sub) {
		visitBinary(sub);
		return null;
	}

	public Object visit(MulExpressionNode mul) {
		visitBinary(mul);
		return null;
	}

	public Object visit(DivExpressionNode div) {
		visitBinary(div);
		return null;
	}

	public Object visit(ModExpressionNode mod) {
		visitBinary(mod);
		return null;
	}

	public Object visit(LtExpressionNode lt) {
		visitBinary(lt);
		return null;
	}

	public Object visit(LeExpressionNode le) {
		visitBinary(le);
		return null;
	}

	public Object visit(GtExpressionNode gt) {
		visitBinary(gt);
		return null;
	}

	public Object visit(GeExpressionNode ge) {
		visitBinary(ge);
		return null;
	}

	public Object visit(EqExpressionNode eq) {
		visitBinary(eq);
		return null;
	}

	public Object visit(NeExpressionNode ne) {
		visitBinary(ne);
		return null;
	}

	public Object visit(AndExpressionNode and) {
		visitBinary(and);
		return null;
	}

	public Object visit(OrExpressionNode or) {
		visitBinary(or);
		return null;
	}

	public Object visit(BreakNode breakStatement) {
		if (loopCount == 0) {
			System.out.println("break statement not in loop");
		}
		return null;
	}

	public Object visit(ContinueNode continueNode) {
		if (loopCount == 0) {
			System.out.println("continue statement not in loop");
		}
		return null;
	}

	public Object visit(ExpressionStatementNode exprStat) {
		exprStat.getExpression().accept(this);
		return null;
	}

	public Object visit(AssignmentNode assign) {
		assign.getExpression().accept(this);
		if (findGlobal(assign.getVariableName())) {
			return null;
		}
		System.out.println("Variable " + assign.getVariableName() + " doesnt exist");
		return null;
	}
}

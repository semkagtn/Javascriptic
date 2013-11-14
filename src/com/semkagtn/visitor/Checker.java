package com.semkagtn.visitor;

import java.util.LinkedList;

import com.semkagtn.tree.AddNode;
import com.semkagtn.tree.AndNode;
import com.semkagtn.tree.AssignmentNode;
import com.semkagtn.tree.BinaryExpressionNode;
import com.semkagtn.tree.BlockNode;
import com.semkagtn.tree.BoolNode;
import com.semkagtn.tree.BreakNode;
import com.semkagtn.tree.ContinueNode;
import com.semkagtn.tree.DivNode;
import com.semkagtn.tree.EqNode;
import com.semkagtn.tree.ExpressionNode;
import com.semkagtn.tree.ExpressionStatementNode;
import com.semkagtn.tree.FunctionCallNode;
import com.semkagtn.tree.FunctionNode;
import com.semkagtn.tree.FunctionParameterNode;
import com.semkagtn.tree.GeNode;
import com.semkagtn.tree.GtNode;
import com.semkagtn.tree.IfElseNode;
import com.semkagtn.tree.LeNode;
import com.semkagtn.tree.LtNode;
import com.semkagtn.tree.ModNode;
import com.semkagtn.tree.MulNode;
import com.semkagtn.tree.NeNode;
import com.semkagtn.tree.NegNode;
import com.semkagtn.tree.NotNode;
import com.semkagtn.tree.NumberNode;
import com.semkagtn.tree.OrNode;
import com.semkagtn.tree.ProgramNode;
import com.semkagtn.tree.ReturnNode;
import com.semkagtn.tree.StatementNode;
import com.semkagtn.tree.StringNode;
import com.semkagtn.tree.SubNode;
import com.semkagtn.tree.UnaryExpressionNode;
import com.semkagtn.tree.UndefNode;
import com.semkagtn.tree.VarNode;
import com.semkagtn.tree.WhileNode;


public class Checker implements AstVisitor<Object> {
	private int functionCount; // for checking return statements
	private int loopCount; // for checking break and continue statements
	private LinkedList<FunctionNode> scopes; // for checking variable declarations
	
	private boolean findVariable(String name) {
		for (FunctionNode scope : scopes) {
			if (scope.findVariable(name)) {
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
		scopes.push(program); // global variables
		for (StatementNode stat : program.getBody()) {
			stat.accept(this);
		}
		scopes.pop();
		return null;
	}

	public Object visit(BlockNode block) {
		for (StatementNode stat : block.getBody()) {
			stat.accept(this);
		}
		return null;
	}

	public Object visit(VarNode var) {
		if (findVariable(var.getName())) {
			return null;
		}
		ErrorHandler.notDefined(var.getPosition(), var.getName());
		return null;
	}

	public Object visit(IfElseNode ifElse) {
		ifElse.getCondition().accept(this);
		ifElse.getIfStatement().accept(this);
		if (ifElse.getElseStatement() != null) {
			ifElse.getElseStatement().accept(this);
		}
		return null;
	}

	public Object visit(WhileNode whileStat) {
		++loopCount;
		whileStat.getCondition().accept(this);
		whileStat.getStatement().accept(this);
		--loopCount;
		return null;
	}

	public Object visit(FunctionCallNode functionCall) {
		functionCall.getFunction().accept(this);
		for (ExpressionNode expr : functionCall.getArguments()) {
			expr.accept(this);
		}
		return null;
	}

	public Object visit(ReturnNode returnStat) {
		if (functionCount == 0) {
			ErrorHandler.returnNotInFunction(returnStat.getPosition());
		}
		returnStat.getValue().accept(this);
		return null;
	}

	public Object visit(FunctionParameterNode functionParam) {
		return null;
	}

	public Object visit(NotNode not) {
		visitUnary(not);
		return null;
	}

	public Object visit(NegNode negation) {
		visitUnary(negation);
		return null;
	}

	public Object visit(AddNode add) {
		visitBinary(add);
		return null;
	}

	public Object visit(SubNode sub) {
		visitBinary(sub);
		return null;
	}

	public Object visit(MulNode mul) {
		visitBinary(mul);
		return null;
	}

	public Object visit(DivNode div) {
		visitBinary(div);
		return null;
	}

	public Object visit(ModNode mod) {
		visitBinary(mod);
		return null;
	}

	public Object visit(LtNode lt) {
		visitBinary(lt);
		return null;
	}

	public Object visit(LeNode le) {
		visitBinary(le);
		return null;
	}

	public Object visit(GtNode gt) {
		visitBinary(gt);
		return null;
	}

	public Object visit(GeNode ge) {
		visitBinary(ge);
		return null;
	}

	public Object visit(EqNode eq) {
		visitBinary(eq);
		return null;
	}

	public Object visit(NeNode ne) {
		visitBinary(ne);
		return null;
	}

	public Object visit(AndNode and) {
		visitBinary(and);
		return null;
	}

	public Object visit(OrNode or) {
		visitBinary(or);
		return null;
	}

	public Object visit(BreakNode breakStat) {
		if (loopCount == 0) {
			ErrorHandler.breakNotInLoop(breakStat.getPosition());
		}
		return null;
	}

	public Object visit(ContinueNode continueNode) {
		if (loopCount == 0) {
			ErrorHandler.continueNotInLoop(continueNode.getPosition());
		}
		return null;
	}

	public Object visit(ExpressionStatementNode exprStat) {
		exprStat.getExpression().accept(this);
		return null;
	}

	public Object visit(AssignmentNode assign) {
		assign.getExpression().accept(this);
		if (findVariable(assign.getVariableName())) {
			return null;
		}
		ErrorHandler.notDefined(assign.getPosition(), assign.getVariableName());
		return null;
	}

	public Object visit(FunctionNode function) {
		++functionCount;
		scopes.push(function);
		for (FunctionParameterNode param : function.getParameters()) {
			param.accept(this);
		}
		for (StatementNode stat : function.getBody()) {
			stat.accept(this);
		}
		scopes.pop();
		--functionCount;
		return null;
	}

	public Object visit(BoolNode bool) {
		return null;
	}

	public Object visit(NumberNode number) {
		return null;
	}

	public Object visit(StringNode string) {
		return null;
	}

	public Object visit(UndefNode undef) {
		return null;
	}
}

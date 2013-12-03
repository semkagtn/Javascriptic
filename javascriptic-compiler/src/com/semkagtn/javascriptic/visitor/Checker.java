package com.semkagtn.javascriptic.visitor;

import java.util.LinkedList;

import com.semkagtn.javascriptic.tree.AddNode;
import com.semkagtn.javascriptic.tree.AndNode;
import com.semkagtn.javascriptic.tree.ArrayNode;
import com.semkagtn.javascriptic.tree.AssignmentNode;
import com.semkagtn.javascriptic.tree.BinaryExpressionNode;
import com.semkagtn.javascriptic.tree.BlockNode;
import com.semkagtn.javascriptic.tree.BoolNode;
import com.semkagtn.javascriptic.tree.DivNode;
import com.semkagtn.javascriptic.tree.DoWhileNode;
import com.semkagtn.javascriptic.tree.EqNode;
import com.semkagtn.javascriptic.tree.ExpressionNode;
import com.semkagtn.javascriptic.tree.ExpressionStatementNode;
import com.semkagtn.javascriptic.tree.FunctionCallNode;
import com.semkagtn.javascriptic.tree.FunctionNode;
import com.semkagtn.javascriptic.tree.FunctionParameterNode;
import com.semkagtn.javascriptic.tree.GeNode;
import com.semkagtn.javascriptic.tree.GetFieldNode;
import com.semkagtn.javascriptic.tree.GtNode;
import com.semkagtn.javascriptic.tree.IfElseNode;
import com.semkagtn.javascriptic.tree.LeNode;
import com.semkagtn.javascriptic.tree.LtNode;
import com.semkagtn.javascriptic.tree.ModNode;
import com.semkagtn.javascriptic.tree.MulNode;
import com.semkagtn.javascriptic.tree.NeNode;
import com.semkagtn.javascriptic.tree.NegNode;
import com.semkagtn.javascriptic.tree.NotNode;
import com.semkagtn.javascriptic.tree.NumberNode;
import com.semkagtn.javascriptic.tree.OrNode;
import com.semkagtn.javascriptic.tree.ProgramNode;
import com.semkagtn.javascriptic.tree.PutFieldNode;
import com.semkagtn.javascriptic.tree.ReturnNode;
import com.semkagtn.javascriptic.tree.StatementNode;
import com.semkagtn.javascriptic.tree.StrictEqNode;
import com.semkagtn.javascriptic.tree.StrictNeNode;
import com.semkagtn.javascriptic.tree.StringNode;
import com.semkagtn.javascriptic.tree.SubNode;
import com.semkagtn.javascriptic.tree.UnaryExpressionNode;
import com.semkagtn.javascriptic.tree.UndefNode;
import com.semkagtn.javascriptic.tree.VarNode;
import com.semkagtn.javascriptic.tree.WhileNode;


public class Checker implements AstVisitor<Object> {
	private int functionCount; // for checking return statements
	private LinkedList<FunctionNode> scopes; // for checking variable declarations
	
	private boolean findVariable(String name) {
		for (String f : LIBRARY) {
			if (f.equals(name)) {
				return true;
			}
		}
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
		whileStat.getCondition().accept(this);
		whileStat.getStatement().accept(this);
		return null;
	}
	
	public Object visit(DoWhileNode doWhile) {
		doWhile.getCondition().accept(this);
		doWhile.getStatement().accept(this);
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
		if (returnStat.getValue() != null) {
			returnStat.getValue().accept(this);
		}
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

	public Object visit(ExpressionStatementNode exprStat) {
		exprStat.getExpression().accept(this);
		return null;
	}

	public Object visit(AssignmentNode assign) {
		assign.getExpression().accept(this);
		assign.getVariable().accept(this);
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

	public Object visit(ArrayNode array) {
		for (ExpressionNode elem : array.getElements()) {
			elem.accept(this);
		}
		return null;
	}

	public Object visit(GetFieldNode getIndex) {
		getIndex.getVariable().accept(this);
		getIndex.getIndex().accept(this);
		return null;
	}

	public Object visit(PutFieldNode putIndex) {
		putIndex.getVariable().accept(this);
		putIndex.getIndex().accept(this);
		putIndex.getExpression().accept(this);
		return null;
	}

	public Object visit(StrictEqNode eq) {
		visitBinary(eq);
		return null;
	}

	public Object visit(StrictNeNode ne) {
		visitBinary(ne);
		return null;
	}
}

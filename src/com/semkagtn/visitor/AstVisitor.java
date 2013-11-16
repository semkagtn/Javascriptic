package com.semkagtn.visitor;

import com.semkagtn.tree.AddNode;
import com.semkagtn.tree.AndNode;
import com.semkagtn.tree.AssignmentNode;
import com.semkagtn.tree.BlockNode;
import com.semkagtn.tree.BoolNode;
import com.semkagtn.tree.BreakNode;
import com.semkagtn.tree.ContinueNode;
import com.semkagtn.tree.DivNode;
import com.semkagtn.tree.EqNode;
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
import com.semkagtn.tree.StringNode;
import com.semkagtn.tree.SubNode;
import com.semkagtn.tree.UndefNode;
import com.semkagtn.tree.VarNode;
import com.semkagtn.tree.WhileNode;

public interface AstVisitor<T> {
	T visit(AddNode add);

	T visit(AndNode and);

	T visit(AssignmentNode assign);

	T visit(BlockNode block);
	
	T visit(BoolNode bool);
	
	T visit(BreakNode breakStat);

	T visit(ContinueNode continueStat);

	T visit(DivNode div);

	T visit(EqNode eq);

	T visit(ExpressionStatementNode exprStat);

	T visit(FunctionCallNode functionCall);

	T visit(FunctionNode function);

	T visit(FunctionParameterNode functionParam);

	T visit(GeNode ge);

	T visit(GtNode gt);

	T visit(IfElseNode ifElse);

	T visit(LeNode le);

	T visit(LtNode lt);

	T visit(ModNode mod);

	T visit(MulNode mul);

	T visit(NegNode neg);

	T visit(NeNode ne);

	T visit(NotNode not);
	
	T visit(NumberNode number);

	T visit(OrNode or);

	T visit(ProgramNode program);

	T visit(ReturnNode returnStat);

	T visit(StringNode string);
	
	T visit(SubNode sub);
	
	T visit(UndefNode undef);

	T visit(VarNode var);

	T visit(WhileNode whileStat);
}
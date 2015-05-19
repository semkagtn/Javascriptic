package com.semkagtn.javascriptic.compiler.visitor;

import com.semkagtn.javascriptic.compiler.tree.AddNode;
import com.semkagtn.javascriptic.compiler.tree.AndNode;
import com.semkagtn.javascriptic.compiler.tree.ArrayNode;
import com.semkagtn.javascriptic.compiler.tree.AssignmentNode;
import com.semkagtn.javascriptic.compiler.tree.BlockNode;
import com.semkagtn.javascriptic.compiler.tree.BoolNode;
import com.semkagtn.javascriptic.compiler.tree.DivNode;
import com.semkagtn.javascriptic.compiler.tree.DoWhileNode;
import com.semkagtn.javascriptic.compiler.tree.EqNode;
import com.semkagtn.javascriptic.compiler.tree.ExpressionStatementNode;
import com.semkagtn.javascriptic.compiler.tree.FunctionCallNode;
import com.semkagtn.javascriptic.compiler.tree.FunctionNode;
import com.semkagtn.javascriptic.compiler.tree.FunctionParameterNode;
import com.semkagtn.javascriptic.compiler.tree.GeNode;
import com.semkagtn.javascriptic.compiler.tree.GetFieldNode;
import com.semkagtn.javascriptic.compiler.tree.GtNode;
import com.semkagtn.javascriptic.compiler.tree.IfElseNode;
import com.semkagtn.javascriptic.compiler.tree.LeNode;
import com.semkagtn.javascriptic.compiler.tree.LtNode;
import com.semkagtn.javascriptic.compiler.tree.ModNode;
import com.semkagtn.javascriptic.compiler.tree.MulNode;
import com.semkagtn.javascriptic.compiler.tree.NeNode;
import com.semkagtn.javascriptic.compiler.tree.NegNode;
import com.semkagtn.javascriptic.compiler.tree.NotNode;
import com.semkagtn.javascriptic.compiler.tree.NumberNode;
import com.semkagtn.javascriptic.compiler.tree.OrNode;
import com.semkagtn.javascriptic.compiler.tree.PlusNode;
import com.semkagtn.javascriptic.compiler.tree.ProgramNode;
import com.semkagtn.javascriptic.compiler.tree.PutFieldNode;
import com.semkagtn.javascriptic.compiler.tree.ReturnNode;
import com.semkagtn.javascriptic.compiler.tree.StrictEqNode;
import com.semkagtn.javascriptic.compiler.tree.StrictNeNode;
import com.semkagtn.javascriptic.compiler.tree.StringNode;
import com.semkagtn.javascriptic.compiler.tree.SubNode;
import com.semkagtn.javascriptic.compiler.tree.UndefNode;
import com.semkagtn.javascriptic.compiler.tree.VarNode;
import com.semkagtn.javascriptic.compiler.tree.WhileNode;

public interface AstVisitor<T> {
	// Standard functions
	public static final String CONSOLE_LIBRARY = "_Console";
	public static final String MATH_LIBRARY = "_Math";
	public static final String[] LIBRARY = {CONSOLE_LIBRARY, MATH_LIBRARY};
	
	T visit(AddNode add);

	T visit(AndNode and);

	T visit(ArrayNode array);
	
	T visit(AssignmentNode assign);

	T visit(BlockNode block);
	
	T visit(BoolNode bool);

	T visit(DivNode div);

	T visit(EqNode eq);

	T visit(ExpressionStatementNode exprStat);

	T visit(FunctionCallNode functionCall);

	T visit(FunctionNode function);

	T visit(FunctionParameterNode functionParam);

	T visit (GetFieldNode getIndex);
	
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

	T visit(PlusNode plus);
	
	T visit(ProgramNode program);
	
	T visit(PutFieldNode putIndex);

	T visit(ReturnNode returnStat);

	T visit(StrictEqNode eq);
	
	T visit(StrictNeNode ne);
	
	T visit(StringNode string);
	
	T visit(SubNode sub);
	
	T visit(UndefNode undef);

	T visit(VarNode var);

	T visit(WhileNode whileStat);
	
	T visit(DoWhileNode doWhile);
}
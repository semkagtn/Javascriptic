package com.semkagtn.javascriptic.visitor;

import com.semkagtn.javascriptic.tree.AddNode;
import com.semkagtn.javascriptic.tree.AndNode;
import com.semkagtn.javascriptic.tree.ArrayNode;
import com.semkagtn.javascriptic.tree.AssignmentNode;
import com.semkagtn.javascriptic.tree.BlockNode;
import com.semkagtn.javascriptic.tree.BoolNode;
import com.semkagtn.javascriptic.tree.DivNode;
import com.semkagtn.javascriptic.tree.EqNode;
import com.semkagtn.javascriptic.tree.ExpressionStatementNode;
import com.semkagtn.javascriptic.tree.FunctionCallNode;
import com.semkagtn.javascriptic.tree.FunctionNode;
import com.semkagtn.javascriptic.tree.FunctionParameterNode;
import com.semkagtn.javascriptic.tree.GeNode;
import com.semkagtn.javascriptic.tree.GetIndexNode;
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
import com.semkagtn.javascriptic.tree.PutIndexNode;
import com.semkagtn.javascriptic.tree.ReturnNode;
import com.semkagtn.javascriptic.tree.StrictEqNode;
import com.semkagtn.javascriptic.tree.StrictNeNode;
import com.semkagtn.javascriptic.tree.StringNode;
import com.semkagtn.javascriptic.tree.SubNode;
import com.semkagtn.javascriptic.tree.UndefNode;
import com.semkagtn.javascriptic.tree.VarNode;
import com.semkagtn.javascriptic.tree.WhileNode;

public interface AstVisitor<T> {
	// Standard functions
	public static final String PRINT_FUNCTION = "_print";
	public static final String READ_FUNCTION = "_read";
	public static final String ROUND_FUNCTION = "_round";
	public static final String LENGTH_FUNCTION = "_length";
	public static final String RANDOM_FUNCTION = "_random";
	public static final String[] LIBRARY = {
		PRINT_FUNCTION, READ_FUNCTION, ROUND_FUNCTION, LENGTH_FUNCTION, RANDOM_FUNCTION};
	
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

	T visit (GetIndexNode getIndex);
	
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
	
	T visit(PutIndexNode putIndex);

	T visit(ReturnNode returnStat);

	T visit(StrictEqNode eq);
	
	T visit(StrictNeNode ne);
	
	T visit(StringNode string);
	
	T visit(SubNode sub);
	
	T visit(UndefNode undef);

	T visit(VarNode var);

	T visit(WhileNode whileStat);
}
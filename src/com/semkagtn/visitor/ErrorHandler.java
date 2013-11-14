package com.semkagtn.visitor;

import com.semkagtn.tree.AstNode;

public class ErrorHandler {	
	private static void error(AstNode.Position pos, String what) {
		System.err.println(pos + ": " + what);
		System.exit(1);
	}
	
	public static void notDefined(AstNode.Position pos, String label) {
		error(pos, "'" + label + "' - variable not defined.");
	}
	
	public static void returnNotInFunction(AstNode.Position pos) {
		error(pos, "'return' statement not in function.");
	}
	
	public static void breakNotInLoop(AstNode.Position pos) {
		error(pos, "'break' statement not in function");
	}
	
	public static void continueNotInLoop(AstNode.Position pos) {
		error(pos, "'continue' statement not in function");
	}
}

package com.semkagtn.javascriptic.visitor;

import com.semkagtn.javascriptic.tree.AstNode;

public class ErrorHandler {	
	private static void error(AstNode.Position pos, String what) {
		System.err.println(pos + ": " + what);
		System.exit(1);
	}
	
	public static void notDefined(AstNode.Position pos, String label) {
		error(pos, "'" + label.substring(1) + "' - variable not defined.");
	}
	
	public static void returnNotInFunction(AstNode.Position pos) {
		error(pos, "'return' statement not in function.");
	}
}

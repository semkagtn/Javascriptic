package com.semkagtn.visitor;

public class ErrorHandler {	
	private static void error(int line, int symbol, String what) {
		System.err.println(line + ":" + symbol + ": " + what);
		System.exit(1);
	}
	
	public static void alreadyDefined(int line, int symbol, String label) {
		error(line, symbol, "'" + label + "' - variable already defined.");
	}
	
	public static void notDefined(int line, int symbol, String label) {
		error(line, symbol, "'" + label + "' - variable not defined.");
	}
	
	public static void returnNotInFunction(int line, int symbol) {
		error(line, symbol, "'return' statement not in function.");
	}
	
	public static void breakNotInLoop(int line, int symbol) {
		error(line, symbol, "'break' statement not in function");
	}
	
	public static void continueNotInLoop(int line, int symbol) {
		error(line, symbol, "'continue' statement not in function");
	}
}

package com.semkagtn;

public class Main {
	
	public static void main(String[] args) {
		Compiler compiler = new Compiler();
		compiler.setInputFileName("func.js");
		compiler.setOutputFileName("Out");
		compiler.run();
	}
	
}

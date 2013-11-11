package com.semkagtn;

public class Main {
	
	public static void main(String[] args) {
		Compiler compiler = new Compiler();
		compiler.setInputFileName("test.js");
		compiler.setOutputFileName("a.pir");
		compiler.run();
	}
	
}

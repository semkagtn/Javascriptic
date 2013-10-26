package com.semkagtn;

public class Main {
	public static void main(String[] args) {
		Compiler compiler = new Compiler();
		compiler.setInputFileName(args[0]);
		compiler.setOutputFileName(args[1]);
		compiler.run();
	}
}

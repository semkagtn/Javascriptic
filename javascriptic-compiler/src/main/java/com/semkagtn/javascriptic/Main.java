package com.semkagtn.javascriptic;

public class Main {
	
	public static void main(String[] args) {
		Compiler compiler = new Compiler();
		if (args.length == 0) {
			System.out.println("Usage: source (target)?");
			System.exit(1);
		}
		compiler.setInputFileName(args[0]);
		String target = args.length > 1 ? args[1] : "Out";
		compiler.setOutputFileName(target);
		compiler.run();
	}
	
}

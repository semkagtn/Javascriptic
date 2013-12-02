package com.semkagtn.javascriptic;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.semkagtn.javascriptic.generated.JavascripticLexer;
import com.semkagtn.javascriptic.generated.JavascripticParser;
import com.semkagtn.javascriptic.tree.ProgramNode;
import com.semkagtn.javascriptic.visitor.AstBuilder;
import com.semkagtn.javascriptic.visitor.Checker;
import com.semkagtn.javascriptic.visitor.CodeGenerator;

public class Compiler {
	private String inputFileName;
	private String outputFileName;
	
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	
	public void run() {
		try {
			CharStream cs = new ANTLRFileStream(inputFileName);
			JavascripticLexer lexer = new JavascripticLexer(cs);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			JavascripticParser parser = new JavascripticParser(tokens);
			// Generating parse tree
			ParseTree tree = parser.program();
			// Generating Abstract syntax tree
			AstBuilder astBuilder = new AstBuilder();
			ProgramNode ast = (ProgramNode) astBuilder.visit(tree);
			// Checking
			Checker checker = new Checker();
			checker.visit(ast);
			// Generating code
			CodeGenerator codeGenerator = new CodeGenerator(outputFileName);
			codeGenerator.visit(ast);
		} catch (Exception e) {
			System.err.println("ERROR: file " + inputFileName + " doesn't exist");
			System.exit(1);
		}
	}
}

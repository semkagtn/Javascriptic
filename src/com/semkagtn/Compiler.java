package com.semkagtn;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.semkagtn.generated.JavascripticLexer;
import com.semkagtn.generated.JavascripticParser;

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
			// Generate parse tree
			ParseTree tree = parser.program();
			// Generate Abstract syntax tree
			//AstBuilder astBuilder = new AstBuilder(outputFileName);
			//ProgramNode ast = (ProgramNode) astBuilder.visit(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

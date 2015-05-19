package com.semkagtn.javascriptic.compiler;

import com.semkagtn.javascriptic.compiler.JavascripticLexer;
import com.semkagtn.javascriptic.compiler.JavascripticParser;
import com.semkagtn.javascriptic.compiler.tree.ProgramNode;
import com.semkagtn.javascriptic.compiler.visitor.AstBuilder;
import com.semkagtn.javascriptic.compiler.visitor.Checker;
import com.semkagtn.javascriptic.compiler.visitor.CodeGenerator;
import com.semkagtn.javascriptic.compiler.visitor.ConstantFolder;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

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
			ParseTree tree = parser.program();
			AstBuilder astBuilder = new AstBuilder();
			ProgramNode ast = (ProgramNode) astBuilder.visit(tree);
			Checker checker = new Checker();
			checker.visit(ast);
            ConstantFolder constantFolder = new ConstantFolder();
            ast = (ProgramNode) constantFolder.visit(ast);
			CodeGenerator codeGenerator = new CodeGenerator(outputFileName);
			codeGenerator.visit(ast);
		} catch (IOException e) {
			System.err.println("ERROR: file " + inputFileName + " doesn't exist");
			System.exit(1);
		}
	}
}

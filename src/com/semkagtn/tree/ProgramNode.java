package com.semkagtn.tree;

import com.semkagtn.visitor.AstVisitor;

public class ProgramNode extends ScopeNode {
	private String programName;
	
	public ProgramNode() {
		programName = "";
	}
	
	public String getProgramName() {
		return programName;
	}
	
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

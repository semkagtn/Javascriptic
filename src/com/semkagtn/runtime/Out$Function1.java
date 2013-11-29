package com.semkagtn.runtime;

public class Out$Function1 extends JSFunction {
	public Out$Scope1 scope1;
	public Out$Scope0 scope0;
	
	public Out$Function1(Out$Scope0 scope0) {
		super("");
		this.scope0 = scope0;
	}
	
	public JSObject call(JSObject... objects) {
		scope1 = new Out$Scope1();
		return JSUndef.UNDEF;
	}
}

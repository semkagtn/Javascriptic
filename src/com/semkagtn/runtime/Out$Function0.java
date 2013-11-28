package com.semkagtn.runtime;

public class Out$Function0 extends JSFunction {

	public Out$Scope0 scope0;
	
	public Out$Function0() {
		super("");
	}
	
	public JSObject call(JSObject... objects) {
		scope0 = new Out$Scope0();
		scope0.x = scope0.x;
		scope0.x.add(new JSString("\n"));
		return JSUndef.UNDEF;
	}

}

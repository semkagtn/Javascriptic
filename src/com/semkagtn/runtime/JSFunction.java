package com.semkagtn.runtime;

public abstract class JSFunction extends JSObject {
	
	public JSFunction() {
		value = "function";
	}
	
	protected JSBool toJSBool() {
		return JSBool.TRUE;
	}

	protected JSNumber toJSNumber() {
		return JSNumber.NAN;
	}

}

package com.semkagtn.runtime;

public abstract class JSFunction extends JSObject {
	
	public JSFunction(String text) {
		value = text;
	}
	
	protected JSBool toJSBool() {
		return JSBool.TRUE;
	}

	protected JSNumber toJSNumber() {
		return JSNumber.NAN;
	}

}

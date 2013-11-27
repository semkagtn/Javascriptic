package com.semkagtn.runtime;

public abstract class JSFunction extends JSString {
	
	public JSFunction(String text) {
		super(text);
	}
	
	public JSObject add(JSObject rhs) {
		return new JSString(value + rhs.value);
	}
	
	protected JSBool toJSBool() {
		return JSBool.TRUE;
	}

	protected JSNumber toJSNumber() {
		return JSNumber.NAN;
	}

}

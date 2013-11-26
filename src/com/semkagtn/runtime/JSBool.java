package com.semkagtn.runtime;

public class JSBool extends JSObject {
	public static final JSBool TRUE = new JSBool("true");
	public static final JSBool FALSE = new JSBool("false");
	
	private JSBool(String value) {
		this.value = value;
	}
	
	public JSBool not() {
		if (this == TRUE) {
			return FALSE;
		}
		return TRUE;
	}
	
	protected JSBool toJSBool() {
		return this;
	}

	protected JSNumber toJSNumber() {
		if (this == TRUE) {
			return new JSNumber("1");
		}
		return new JSNumber("0");
	}

}

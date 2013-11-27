package com.semkagtn.runtime;

public class JSBool extends JSObject {
	public static final JSBool TRUE = new JSBool("true");
	public static final JSBool FALSE = new JSBool("false");
	
	public int toInt() {
		return this == TRUE ? 1 : 0;
	}
	
	private JSBool(String value) {
		this.value = value;
	}
	
	public JSObject not() {
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

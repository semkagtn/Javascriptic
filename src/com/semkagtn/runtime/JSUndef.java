package com.semkagtn.runtime;

public class JSUndef extends JSPrimitive {
	public static final JSUndef UNDEF = new JSUndef();
	
	private JSUndef() {
		this.value = "undefined";
	}
	
	protected JSBool toJSBool() {
		return JSBool.FALSE;
	}

	protected JSNumber toJSNumber() {
		return JSNumber.NAN;
	}
}

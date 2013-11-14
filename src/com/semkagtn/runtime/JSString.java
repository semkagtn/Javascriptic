package com.semkagtn.runtime;

public class JSString extends JSPrimitive {

	public JSString(String value) {
		this.value = value;
	}
	
	public JSString add(JSObject rhs) {
		return new JSString(value + rhs.value);
	}
	
	public JSBool lt(JSString rhs) {
		int res = value.compareTo(rhs.value);
		if (res == -1) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	public JSBool le(JSString rhs) {
		int res = value.compareTo(rhs.value);
		if (res == -1 || res == 0) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	public JSBool ge(JSString rhs) {
		int res = value.compareTo(rhs.value);
		if (res == 1 || res == 0) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	public JSBool gt(JSString rhs) {
		int res = value.compareTo(rhs.value);
		if (res == 1) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	public JSBool eq(JSString rhs) {
		int res = value.compareTo(rhs.value);
		if (res == 0) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	public JSBool ne(JSString rhs) {
		int res = value.compareTo(rhs.value);
		if (res != 0) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	protected JSBool toJSBool() {
		if (value.equals("")) {
			return JSBool.FALSE;
		}
		return JSBool.TRUE;
	}

	protected JSNumber toJSNumber() {
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return JSNumber.NAN;
		}
		return new JSNumber(value);
	}
}

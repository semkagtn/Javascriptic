package com.semkagtn.runtime;

public class JSString extends JSObject {
	public static final JSString EMPTY = new JSString("");
	
	public JSString(String value) {
		this.value = value;
	}
	
	public JSString add(JSObject rhs) {
		return new JSString(value + rhs.value);
	}
	
	public JSBool lt(JSObject rhs) {
		if (rhs instanceof JSString) {
			int res = value.compareTo(rhs.value);
			if (res == -1) {
				return JSBool.TRUE;
			}
			return JSBool.FALSE;
		}
		return super.lt(rhs);
	}
	
	public JSBool le(JSObject rhs) {
		return gt(rhs).not();
	}
	
	public JSBool ge(JSObject rhs) {
		return lt(rhs).not();
	}
	
	public JSBool gt(JSObject rhs) {
		if (rhs instanceof JSString) {
			int res = value.compareTo(rhs.value);
			if (res == 1) {
				return JSBool.TRUE;
			}
			return JSBool.FALSE;
		}
		return super.gt(rhs);
	}
	
	public JSBool eq(JSObject rhs) {
		if (rhs instanceof JSString) {
			int res = value.compareTo(rhs.value);
			if (res == 0) {
				return JSBool.TRUE;
			}
			return JSBool.FALSE;
		}
		return super.eq(rhs);
	}
	
	public JSBool ne(JSObject rhs) {
		return eq(rhs).not();
	}
	
	protected JSBool toJSBool() {
		if (value.equals(EMPTY)) {
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

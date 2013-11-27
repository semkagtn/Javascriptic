package com.semkagtn.runtime;

public class JSString extends JSObject {
	public static final JSString EMPTY = new JSString("");
	
	public JSString(String value) {
		this.value = value;
	}
	
	public JSObject add(JSObject rhs) {
		return new JSString(value + rhs.value);
	}
	
	public JSObject lt(JSObject rhs) {
		if (rhs instanceof JSString) {
			int res = value.compareTo(rhs.value);
			if (res == -1) {
				return JSBool.TRUE;
			}
			return JSBool.FALSE;
		}
		return super.lt(rhs);
	}
	
	public JSObject le(JSObject rhs) {
		return gt(rhs).not();
	}
	
	public JSObject ge(JSObject rhs) {
		return lt(rhs).not();
	}
	
	public JSObject gt(JSObject rhs) {
		if (rhs instanceof JSString) {
			int res = value.compareTo(rhs.value);
			if (res == 1) {
				return JSBool.TRUE;
			}
			return JSBool.FALSE;
		}
		return super.gt(rhs);
	}
	
	public JSObject eq(JSObject rhs) {
		if (rhs instanceof JSString) {
			int res = value.compareTo(rhs.value);
			if (res == 0) {
				return JSBool.TRUE;
			}
			return JSBool.FALSE;
		}
		return super.eq(rhs);
	}
	
	public JSObject ne(JSObject rhs) {
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

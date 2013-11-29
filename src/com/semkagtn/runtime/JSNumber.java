package com.semkagtn.runtime;

public class JSNumber extends JSObject { 
	public static final JSNumber NAN = new JSNumber("NaN");
	
	public JSNumber(String value) {
		this.value = value;
	}
	
	public JSObject sub(JSObject rhs) {
		double res = Double.parseDouble(value) - Double.parseDouble(rhs.value);
		if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY
				|| res == Double.NaN) {
			return NAN;
		}
		String str = (long) res == res ? "" + (long) res : "" + res;
		return new JSNumber(str);
	}
	
	public JSObject mul(JSObject rhs) {
		double res = Double.parseDouble(value) * Double.parseDouble(rhs.value);
		if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY
				|| res == Double.NaN) {
			return NAN;
		}
		String str = (long) res == res ? "" + (long) res : "" + res;
		return new JSNumber(str);
	}
	
	public JSObject div(JSObject rhs) {
		double res = Double.parseDouble(value) / Double.parseDouble(rhs.value);
		if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY
				|| res == Double.NaN) {
			return NAN;
		}
		String str = (long) res == res ? "" + (long) res : "" + res;
		return new JSNumber(str);
	}
	
	public JSObject neg() {
		double res = -Double.parseDouble(value);
		String str = (long) res == res ? "" + (long) res : "" + res;
		return new JSNumber(str);
	}
	
	public JSObject lt(JSObject rhs) {
		if (Double.parseDouble(value) < Double.parseDouble(rhs.value)) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	public JSObject gt(JSObject rhs) {
		if (Double.parseDouble(value) > Double.parseDouble(rhs.value)) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	public JSObject eq(JSObject rhs) {
		if (Double.parseDouble(value) == Double.parseDouble(rhs.value)) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	protected JSBool toJSBool() {
		if (value.equals(NAN) || Double.parseDouble(value) == 0) {
			return JSBool.FALSE;
		}
		return JSBool.TRUE;
	}

	protected JSNumber toJSNumber() {
		return this;
	}
}

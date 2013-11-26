package com.semkagtn.runtime;

public class JSNumber extends JSObject { 
	public static final JSNumber NAN = new JSNumber("NaN");
	
	public JSNumber(String value) {
		this.value = value;
	}
	
	public JSNumber sub(JSObject rhs) {
		double res = Double.parseDouble(value) - Double.parseDouble(rhs.value);
		if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY
				|| res == Double.NaN) {
			return NAN;
		}
		return new JSNumber(Double.toString(res));
	}
	
	public JSNumber mul(JSObject rhs) {
		double res = Double.parseDouble(value) * Double.parseDouble(rhs.value);
		if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY
				|| res == Double.NaN) {
			return NAN;
		}
		return new JSNumber(Double.toString(res));
	}
	
	public JSNumber div(JSObject rhs) {
		double res = Double.parseDouble(value) / Double.parseDouble(rhs.value);
		if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY
				|| res == Double.NaN) {
			return NAN;
		}
		return new JSNumber(Double.toString(res));
	}
	
	public JSNumber neg() {
		double res = -Double.parseDouble(value);
		return new JSNumber(Double.toString(res));
	}
	
	public JSBool lt(JSObject rhs) {
		if (Double.parseDouble(value) < Double.parseDouble(rhs.value)) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	public JSBool gt(JSObject rhs) {
		if (Double.parseDouble(value) > Double.parseDouble(rhs.value)) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	public JSBool eq(JSObject rhs) {
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

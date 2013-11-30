package com.semkagtn.javascriptic.runtime;

public class JSNumber extends JSObject { 
	public static final JSNumber NAN = new JSNumber("NaN");
	
	public JSNumber(String value) {
		this.value = value;
	}
	
	public JSString toJSString() {
		double d = Double.parseDouble(value);
		if (d == (long) d) {
			return new JSString((long) d + "");
		}
		return new JSString(d + "");
	}
	
	public JSObject sub(JSObject rhs) {
		double res = Double.parseDouble(value) - Double.parseDouble(rhs.value);
		if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY
				|| res == Double.NaN) {
			return NAN;
		}
		return new JSNumber(res + "");
	}
	
	public JSObject mul(JSObject rhs) {
		double res = Double.parseDouble(value) * Double.parseDouble(rhs.value);
		if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY
				|| res == Double.NaN) {
			return NAN;
		}
		return new JSNumber(res + "");
	}
	
	public JSObject div(JSObject rhs) {
		double res = Double.parseDouble(value) / Double.parseDouble(rhs.value);
		if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY
				|| res == Double.NaN) {
			return NAN;
		}
		return new JSNumber(res + "");
	}
	
	public JSObject neg() {
		double res = -Double.parseDouble(value);
		return new JSNumber(res + "");
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

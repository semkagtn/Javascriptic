package com.semkagtn.javascriptic.runtime;

public abstract class JSObject {
	protected String value;

	protected abstract JSBool toJSBool();
	protected abstract JSNumber toJSNumber();
	
	protected JSString toJSString() {
		return new JSString(value);
	}
	
	public String toString() {
		return value;
	}
	
	public int toInt() {
		JSBool b = this.toJSBool();
		return b.toInt();
	}
	
	public JSObject length() {
		return JSUndef.UNDEF;
	}
	
	public JSObject call(JSObject[] objects) {
		System.err.println("Runtime error");
		System.exit(1);
		return null;
	}
	
	public JSObject add(JSObject rhs) {
		if (rhs instanceof JSString) {
			return this.toJSString().add(rhs);
		}
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		double res = Double.parseDouble(l.value) + Double.parseDouble(r.value);
		if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY
				|| res == Double.NaN) {
			return JSNumber.NAN;
		}
		String str = (long) res == res ? "" + (long) res : "" + res;
		return new JSNumber(str);
	}
	
	public JSObject and(JSObject rhs) {
		JSBool l = this.toJSBool();
		if (l == JSBool.FALSE) {
			return this;
		}
		return rhs;
	}
	
	public JSObject div(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		
		return l.div(r);
	}

	public JSObject eq(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.eq(r);
	}

	public JSObject ge(JSObject rhs) {
		return lt(rhs).not();
	}

	public JSObject gt(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.gt(r);
	}

	public JSObject le(JSObject rhs) {
		return gt(rhs).not();
	}
	
	public JSObject lt(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.lt(r);
	}

	public JSObject mod(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.mod(r);
	}

	public JSObject mul(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.mul(r);
	}

	public JSObject neg() {
		JSNumber t = this.toJSNumber();
		return t.neg();
	}

	public JSObject ne(JSObject rhs) {
		return eq(rhs).not();
	}

	public JSObject not() {
		JSBool t = this.toJSBool();
		return t.not();
	}

	public JSObject or(JSObject rhs) {
		JSBool l = this.toJSBool();
		if (l == JSBool.TRUE) {
			return this;
		}
		return rhs;
	}

	public JSObject sub(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.sub(r);
	}
}

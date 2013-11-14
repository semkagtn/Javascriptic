package com.semkagtn.runtime;

public abstract class JSObject {
	protected String value;

	protected abstract JSBool toJSBool();
	protected abstract JSNumber toJSNumber();
	public abstract JSObject call();
	
	public String toString() {
		return value;
	}
	
	public JSObject add(JSObject rhs) {
		/*if (rhs instanceof JSString) {
			return new JSString(value + rhs.value);
		}*/
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.add(r);
	}
	
	public JSObject and(JSObject rhs) {
		JSBool l = this.toJSBool();
		if (l == JSBool.FALSE) {
			return this;
		}
		return rhs;
	}
	
	public JSNumber div(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		
		return l.div(r);
	}

	public JSBool eq(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.eq(r);
	}

	public JSBool ge(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.ge(r);
	}

	public JSBool gt(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.gt(r);
	}

	public JSBool le(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.le(r);
	}
	
	public JSBool lt(JSObject rhs) {
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

	public JSNumber neg() {
		JSNumber t = this.toJSNumber();
		return t.neg();
	}

	public JSBool ne(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.ne(r);
	}

	public JSBool not() {
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

	public JSNumber sub(JSObject rhs) {
		JSNumber l = this.toJSNumber();
		JSNumber r = rhs.toJSNumber();
		return l.sub(r);
	}
}
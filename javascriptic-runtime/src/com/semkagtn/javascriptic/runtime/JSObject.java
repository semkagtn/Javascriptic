package com.semkagtn.javascriptic.runtime;
public abstract class JSObject {
	private Type type;
	protected String value;
	
	public JSObject(Type type, String value) {
		this.type = type;
		this.value = value;
	}
	
	// Need to overload in Objects (Not-primitive types)
	protected JSObject toJSPrimitive(Type hint) {
		return this;
	}
	
	private JSObject toJSPrimitive() {
		return toJSPrimitive(Type.STRING);
	}
	
	// Need to overload in JSFunction
	public JSObject call(JSObject... objects) {
		System.err.println("RUNTIME ERROR: object '" +
				this.toJSString().value + "' is not callable.");
		System.exit(1);
		return null;
	}
	
	// Need to overload in JSArray
	public JSObject get(JSObject index) {
		return JSUndef.UNDEF;
	}
	
	// Need to overload in JSArray
	public JSObject put(JSObject index, JSObject value) {
		return value;
	}
	
	private JSObject compare(JSObject rhs, boolean leftFirst) {
		JSObject lPrimitive, rPrimitive;
		if (leftFirst) {
			lPrimitive = this.toJSPrimitive(Type.NUMBER);
			rPrimitive = rhs.toJSPrimitive(Type.NUMBER);
		} else {
			lPrimitive = rhs.toJSPrimitive(Type.NUMBER);
			rPrimitive = this.toJSPrimitive(Type.NUMBER);
		}
		if (lPrimitive.type == Type.STRING && rPrimitive.type == Type.STRING) {
			int result = lPrimitive.value.compareTo(rPrimitive.value);
			return result == -1 ? JSBool.TRUE : JSBool.FALSE;
		}
		JSObject lNumber = lPrimitive.toJSNumber();
		JSObject rNumber = rPrimitive.toJSNumber();
		if (lNumber == JSNumber.NAN) {
			return JSUndef.UNDEF;
		}
		if (rNumber == JSNumber.NAN) {
			return JSUndef.UNDEF;
		}
		double lValue = Double.parseDouble(lNumber.value);
		double rValue = Double.parseDouble(rNumber.value);
		return lValue < rValue ? JSBool.TRUE : JSBool.FALSE;
	}
	
	private JSObject toJSBool() {
		if (type == Type.UNDEF) {
			return JSBool.FALSE;
		}
		if (type == Type.BOOL) {
			return this;
		}
		if (type == Type.NUMBER) {
			return this.ne(JSNumber.ZERO);
		}
		if (type == Type.STRING) {
			return this.ne(JSString.EMPTY);
		}
		return JSBool.TRUE;
	}
	
	protected JSObject toJSNumber() {
		if (type == Type.UNDEF) {
			return JSNumber.NAN;
		}
		if (type == Type.BOOL) {
			return this == JSBool.TRUE ? JSNumber.ONE : JSNumber.ZERO;
		}
		if (type == Type.NUMBER) {
			return this;
		}
		if (type == Type.STRING) {
			String strValue = "0" + value;
			double d;
			try {
				d = Double.parseDouble(strValue);
			} catch (NumberFormatException e) {
				return JSNumber.NAN;
			}
			return new JSNumber(Double.toString(d));
		}
		return this.toJSPrimitive(Type.NUMBER);
	}
	
	protected JSObject toJSString() {
		if (type == Type.STRING) {
			return this;
		}
		if (type == Type.UNDEF || type == Type.BOOL) {
			return new JSString(value);
		}
		if (type == Type.NUMBER) {
			double d = Double.parseDouble(value);
			if (d == (long) d) {
				int i = (int) d;
				return new JSString(i + "");
			}
			return new JSString(value);
		}
		return this.toJSPrimitive(Type.STRING);
	}
	
	public JSObject neg() {
		JSObject number = this.toJSNumber();
		if (number == JSNumber.NAN) {
			return JSNumber.NAN;
		}
		double d = Double.parseDouble(number.value);
		d = -d;
		return new JSNumber(d + "");
	}
	
	public JSObject not() {
		JSObject bool = this.toJSBool();
		if (bool == JSBool.FALSE) {
			return JSBool.TRUE;
		}
		return JSBool.FALSE;
	}
	
	public JSObject mul(JSObject rhs) {
		JSObject l = this.toJSNumber();
		JSObject r = rhs.toJSNumber();
		double lValue, rValue;
		try {
			lValue = Double.parseDouble(l.value);
			rValue = Double.parseDouble(r.value);
		} catch (NumberFormatException e) {
			return JSNumber.NAN;
		}
		return new JSNumber(Double.toString(lValue * rValue));
	}
	
	public JSObject mod(JSObject rhs) {
		JSObject l = this.toJSNumber();
		JSObject r = rhs.toJSNumber();
		double lValue, rValue;
		try {
			lValue = Double.parseDouble(l.value);
			rValue = Double.parseDouble(r.value);
		} catch (NumberFormatException e) {
			return JSNumber.NAN;
		}
		return new JSNumber(Double.toString(lValue % rValue));
	}
	
	public JSObject div(JSObject rhs) {
		JSObject l = this.toJSNumber();
		JSObject r = rhs.toJSNumber();
		double lValue, rValue;
		try {
			lValue = Double.parseDouble(l.value);
			rValue = Double.parseDouble(r.value);
		} catch (NumberFormatException e) {
			return JSNumber.NAN;
		}
		double res = lValue / rValue;
		if (res == Double.NaN || res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY) {
			return JSNumber.NAN;
		}
		return new JSNumber(Double.toString(res));
	}
	
	public JSObject sub(JSObject rhs) {
		JSObject l = this.toJSNumber();
		JSObject r = rhs.toJSNumber();
		double lValue, rValue;
		try {
			lValue = Double.parseDouble(l.value);
			rValue = Double.parseDouble(r.value);
		} catch (NumberFormatException e) {
			return JSNumber.NAN;
		}
		return new JSNumber(Double.toString(lValue - rValue));
	}
	
	public JSObject add(JSObject rhs) {
		JSObject l = this.toJSPrimitive();
		JSObject r = rhs.toJSPrimitive();
		if (l.type == Type.STRING) {
			JSObject rString = r.toJSString();
			return new JSString(l.value + rString.value);
		} else if (r.type == Type.STRING) {
			JSObject lString = l.toJSString();
			return new JSString(lString.value + r.value);
		}
		JSObject lNumber = this.toJSNumber();
		JSObject rNumber = rhs.toJSNumber();
		double lValue, rValue;
		try {
			lValue = Double.parseDouble(lNumber.value);
			rValue = Double.parseDouble(rNumber.value);
		} catch (NumberFormatException e) {
			return JSNumber.NAN;
		}
		return new JSNumber(Double.toString(lValue + rValue));
	}
	
	public JSObject eq(JSObject rhs) {
		if (this.type == rhs.type) {
			if (this.type == Type.UNDEF) {
				return JSBool.TRUE;
			}
			if (this.type == Type.NUMBER) {
				if (this == JSNumber.NAN) {
					return JSBool.FALSE;
				}
				if (rhs == JSNumber.NAN) {
					return JSBool.FALSE;
				}
				if (Double.parseDouble(this.value) == Double.parseDouble(rhs.value)) {
					return JSBool.TRUE;
				}
				return JSBool.FALSE;
			}
			if (this.type == Type.STRING) {
				return this.value.equals(rhs.value) ? JSBool.TRUE : JSBool.FALSE;
			}
			return this == rhs ? JSBool.TRUE : JSBool.FALSE;
		}
		if (this.type == Type.NUMBER && rhs.type == Type.STRING) {
			return this.eq(rhs.toJSNumber());
		}
		if (this.type == Type.STRING && rhs.type == Type.NUMBER) {
			return this.toJSNumber().eq(rhs);
		}
		if (this.type == Type.BOOL) {
			return this.toJSNumber().eq(rhs);
		}
		if (rhs.type == Type.BOOL) {
			return this.eq(rhs.toJSNumber());
		}
		if ((this.type == Type.STRING || this.type == Type.NUMBER) && rhs.type == Type.OBJECT) {
			return this.eq(rhs.toJSPrimitive());
		}
		if (this.type == Type.OBJECT && (rhs.type == Type.STRING || rhs.type == Type.NUMBER)) {
			return this.toJSPrimitive().eq(rhs);
		}
		return JSBool.FALSE;
	}
	
	public JSObject ne(JSObject rhs) {
		return this.eq(rhs).not();
	}
	
	public JSObject strictEq(JSObject rhs) {
		if (this.type != rhs.type) {
			return JSBool.FALSE;
		}
		if (this.type == Type.UNDEF) {
			return JSBool.TRUE;
		}
		if (this.type == Type.NUMBER) {
			if (this == JSNumber.NAN || rhs == JSNumber.NAN) {
				return JSBool.FALSE;
			}
			double l = Double.parseDouble(this.value);
			double r = Double.parseDouble(rhs.value);
			return l == r ? JSBool.TRUE : JSBool.FALSE;
		}
		if (this.type == Type.STRING) {
			return this.value.equals(rhs.value) ? JSBool.TRUE : JSBool.FALSE;
		}
		return this == rhs ? JSBool.TRUE : JSBool.FALSE;
	}
	
	public JSObject strictNe(JSObject rhs) {
		return this.strictEq(rhs).not();
	}
	
	public JSObject lt(JSObject rhs) {
		JSObject result = this.compare(rhs, true);
		return result == JSUndef.UNDEF ? JSBool.FALSE : result;
	}
	
	public JSObject gt(JSObject rhs) {
		JSObject result = this.compare(rhs, false);
		return result == JSUndef.UNDEF ? JSBool.FALSE : result;
	}
	
	public JSObject le(JSObject rhs) {
		JSObject result = this.compare(rhs, false);
		return (result == JSBool.TRUE || result == JSUndef.UNDEF) ? JSBool.FALSE : JSBool.TRUE;
	}
	
	public JSObject ge(JSObject rhs) {
		JSObject result = this.compare(rhs, true);
		return (result == JSBool.TRUE || result == JSUndef.UNDEF) ? JSBool.FALSE : JSBool.TRUE;
	}
	
	public JSObject and(JSObject rhs) {
		return this.toJSBool() == JSBool.FALSE ? this : rhs;
	}
	
	public JSObject or(JSObject rhs) {
		return this.toJSBool() == JSBool.TRUE ? this : rhs;
	}
	
	// Needs for compiler
	public int toInt() {
		return this.toJSBool() == JSBool.TRUE ? 1 : 0;
	}
}

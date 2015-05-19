package com.semkagtn.javascriptic.runtime;

public abstract class JSObject {
	private Type type;
	protected String value;
	protected double number;
	
	public JSObject(Type type) {
		this.type = type;
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
		if (lNumber == JSNumber.NAN || rNumber == JSNumber.NAN) {
			return JSUndef.UNDEF;
		}
		return lNumber.number < rNumber.number ? JSBool.TRUE : JSBool.FALSE;
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
			String strValue = value;
			double d;
			try {
				d = Double.parseDouble(strValue);
			} catch (NumberFormatException e) {
				return JSNumber.NAN;
			}
			if (d == Double.NaN) {
				return JSNumber.NAN;
			}
			return new JSNumber(d);
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
			if (this.number == (long) this.number) {
				int i = (int) this.number;
				return new JSString(i + "");
			}
			return new JSString(number + "");
		}
		return this.toJSPrimitive(Type.STRING);
	}
	
	public JSObject neg() {
		JSObject number = this.toJSNumber();
		if (number == JSNumber.NAN) {
			return JSNumber.NAN;
		}
		return new JSNumber(-this.number);
	}
	
	public JSObject plus() {
		return this.toJSNumber();
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
		if (l == JSNumber.NAN || r == JSNumber.NAN) {
			return JSNumber.NAN;
		}
		return new JSNumber(l.number * r.number);
	}
	
	public JSObject mod(JSObject rhs) {
		JSObject l = this.toJSNumber();
		JSObject r = rhs.toJSNumber();
		if (l == JSNumber.NAN || r == JSNumber.NAN) {
			return JSNumber.NAN;
		}
		return new JSNumber(l.number % r.number);
	}
	
	public JSObject div(JSObject rhs) {
		JSObject l = this.toJSNumber();
		JSObject r = rhs.toJSNumber();
		if (l == JSNumber.NAN || r == JSNumber.NAN) {
			return JSNumber.NAN;
		}
		double res = l.number / r.number;
		if (res == Double.NaN) {
			return JSNumber.NAN;
		}
		if (res == Double.POSITIVE_INFINITY) {
			return JSNumber.POS_INFINITY;
		}
		if (res == Double.NEGATIVE_INFINITY) {
			return JSNumber.NEG_INFINITY;
		}
		return new JSNumber(res);
	}
	
	public JSObject sub(JSObject rhs) {
		JSObject l = this.toJSNumber();
		JSObject r = rhs.toJSNumber();
		if (l == JSNumber.NAN || r == JSNumber.NAN) {
			return JSNumber.NAN;
		}
		return new JSNumber(l.number - r.number);
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
		if (lNumber == JSNumber.NAN || rNumber == JSNumber.NAN) {
			return JSNumber.NAN;
		}
		return new JSNumber(lNumber.number + rNumber.number);
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
				if (this.number == rhs.number) {
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
			return this.number == rhs.number ? JSBool.TRUE : JSBool.FALSE;
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

    public Type getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}

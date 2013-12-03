package com.semkagtn.javascriptic.runtime;

public abstract class JSFunction extends JSObject {
	
	protected JSObject toJSPrimitive(Type hint) {
		if (hint == Type.NUMBER) {
			return JSNumber.NAN;
		}
		return new JSString(value);
	}
	
	public JSFunction(String text) {
		super(Type.OBJECT, text);
	}
}

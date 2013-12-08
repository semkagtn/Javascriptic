package com.semkagtn.javascriptic.runtime;

import java.util.HashMap;

public class JSArray extends JSObject {
	private HashMap<String, JSObject> a;
	
	public JSArray(JSObject... objects) {
		super(Type.OBJECT);
		a = new HashMap<>();
		if (objects.length == 0) {
			a.put("length", JSNumber.ZERO);
		} else {
			a.put("length", new JSNumber(objects.length));
		}
		for (int i = 0; i < objects.length; i++) {
			a.put(i + "", objects[i]);
		}
	}
	
	protected JSObject toJSPrimitive(Type hint) {
		if (hint == Type.NUMBER) {
			if (a.get("length") == JSNumber.ZERO) {
				return JSNumber.ZERO;
			} else if (a.get("length") == JSNumber.ONE) {
				return a.get(0);
			}
			return JSNumber.NAN;
		}
		StringBuilder result = new StringBuilder();
		int length = (int) a.get("length").number;
		for (int i = 0; i < length; i++) {
			String key = i + "";
			if (a.containsKey(key)) {
				result.append(a.get(key).toJSString().value);
			}
			if (i != length - 1) {
				result.append(",");
			}
		}
		return new JSString(result.toString());
	}
	
	public JSObject get(JSObject index) {
		String key = index.toJSString().value;
		if (a.containsKey(key)) {
			return a.get(key);
		}
		return JSUndef.UNDEF;
	}
	
	public JSObject put(JSObject index, JSObject value) {
		String strIndex = index.toJSString().value;
		a.put(strIndex, value);
		try {
			double d = Double.parseDouble(strIndex);
			if (d == (long) d) {
				int length = (int) a.get("length").number;
				int i = (int) d;
				if (i >= length) {
					a.put("length", new JSNumber(i + 1));
				}
			}
		} catch (NumberFormatException e) {
			
		}
		return value;
	}
}

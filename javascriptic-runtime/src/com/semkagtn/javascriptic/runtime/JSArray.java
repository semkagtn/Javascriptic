package com.semkagtn.javascriptic.runtime;
import java.util.HashMap;

public class JSArray extends JSObject {
	private HashMap<String, JSObject> a;
	private int length;
	
	public JSArray(JSObject[] objects) {
		super(Type.OBJECT, "");
		a = new HashMap<>();
		length = objects.length;
		for (int i = 0; i < length; i++) {
			a.put(i + "", objects[i]);
		}
	}
	
	protected JSObject length() {
		return new JSNumber(length + "");
	}
	
	protected JSObject toJSPrimitive(Type hint) {
		if (hint == Type.NUMBER) {
			if (length == 0) {
				return JSNumber.ZERO;
			} else if (length == 1) {
				return a.get(0);
			}
			return JSNumber.NAN;
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; i++) {
			String key = i + "";
			if (a.containsKey(key)) {
				result.append(a.get(key).toJSPrimitive(Type.STRING).value);
			}
			if (i != length - 1) {
				result.append(",");
			}
		}
		return new JSString(result.toString());
	}
	
	public JSObject get(JSObject index) {
		String key = index.toJSPrimitive(Type.STRING).value;
		if (a.containsKey(key)) {
			return a.get(key);
		}
		return JSUndef.UNDEF;
	}
	
	public JSObject put(JSObject index, JSObject value) {
		String strIndex = index.toJSPrimitive(Type.STRING).value;
		a.put(strIndex, value);
		try {
			double d = Double.parseDouble(strIndex);
			if (d == (long) d) {
				int i = (int) d;
				if (i >= length) {
					length = i + 1;
				}
			}
		} catch (NumberFormatException e) {
			
		}
		return value;
	}
}

package com.semkagtn.javascriptic.runtime;

import java.util.HashMap;

public class JSArray extends JSString {

	private int length;
	private HashMap<String, JSObject> a;
	
	public JSArray(JSObject[] objects) {
		super("");
		length = objects.length;
		a = new HashMap<>();
		for (int i = 0; i < length; i++) {
			a.put(i + "", objects[i]);
		}
	}
	
	public JSObject add(JSObject rhs) {
		return this.toJSString().add(rhs);
	}
	
	public JSObject length() {
		return new JSNumber(length + "");
	}
	
	public JSObject get(JSObject index) {
		JSString strIndex = index.toJSString();
		if (a.containsKey(strIndex.value)) {
			return a.get(strIndex.value);
		}
		return JSUndef.UNDEF;
	}
	
	public JSObject put(JSObject index, JSObject value) {
		JSString strIndex = index.toJSString();
		a.put(strIndex.value, value);
		try {
			double d = Double.parseDouble(strIndex.value);
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
	
	public JSString toJSString() {
		String res = "";
		for (int i = 0; i < length; i++) {
			String key = i + "";
			if (a.containsKey(key)) {
				res += a.get(key).toJSString().toString();
			}
			res += ",";
		}
		if (!res.equals("")) {
			res = res.substring(0, res.length() - 1);
		}
		return new JSString(res);
	}

}

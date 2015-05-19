package com.semkagtn.javascriptic.runtime;

public class JSString extends JSObject {
	private JSObject length;
	
	public static final JSString EMPTY = new JSString("");
	
	public JSObject get(JSObject index) {
		JSObject strIndex = index.toJSString();
		if (strIndex.value.equals("length")) {
			return length;
		}
		try {
			double d = Double.parseDouble(strIndex.value);
			if (d == (long) d) {
				int i = (int) d;
				return new JSString(value.toCharArray()[i] + ""); 
			}
		} catch (Exception e) {
			return JSUndef.UNDEF;
		}
		return JSUndef.UNDEF;
	}
	
	public JSString(String value) {
		super(Type.STRING);
		this.value = value;
		length = new JSNumber(value.length());
	}
}

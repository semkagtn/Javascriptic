package com.semkagtn.javascriptic.runtime;
public class JSString extends JSObject {
	public static final JSString EMPTY = new JSString("");
	
	public JSString(String value) {
		super(Type.STRING, value);
	}
}

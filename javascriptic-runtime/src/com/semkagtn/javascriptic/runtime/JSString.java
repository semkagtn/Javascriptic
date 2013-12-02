package com.semkagtn.javascriptic.runtime;
public class JSString extends JSObject {
	public JSString(String value) {
		super(Type.STRING, value);
	}
}

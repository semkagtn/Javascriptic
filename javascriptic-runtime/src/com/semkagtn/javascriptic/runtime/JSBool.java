package com.semkagtn.javascriptic.runtime;
public class JSBool extends JSObject {
	public static final JSBool TRUE = new JSBool("true");
	public static final JSBool FALSE = new JSBool("false");
	
	private JSBool(String value) {
		super(Type.BOOL, value);
	}
}

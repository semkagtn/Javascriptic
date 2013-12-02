package com.semkagtn.javascriptic.runtime;
public class JSNumber extends JSObject {
	public static final JSNumber NAN = new JSNumber("NaN");
	public static final JSNumber ZERO = new JSNumber("0.0");
	public static final JSNumber ONE = new JSNumber("1.0");
	
	public JSNumber(String value) {
		super(Type.NUMBER, value);
	}
}

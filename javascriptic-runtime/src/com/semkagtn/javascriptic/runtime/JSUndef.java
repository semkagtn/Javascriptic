package com.semkagtn.javascriptic.runtime;
public class JSUndef extends JSObject {
	public static final JSUndef UNDEF = new JSUndef();
	
	private JSUndef() {
		super(Type.UNDEF, "undefined");
	}
}

package com.semkagtn.runtime;

public abstract class JSPrimitive extends JSObject {
	public JSObject call(JSObject... objects) {
		System.err.println("Runtime Error");
		System.exit(1);
		return null;
	}
}

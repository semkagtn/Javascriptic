package com.semkagtn.javascriptic.runtime;

public class Test {
	public static void main(String[] args) {
		JSObject array = new JSArray(new JSObject[0]);
		array.put(new JSNumber("0"), new JSNumber("0"));
	}
}

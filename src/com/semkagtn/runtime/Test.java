package com.semkagtn.runtime;

public class Test {
	public static void main(String[] args) {
		JSObject s = new JSString("2.0").add(new JSNumber("5.0"));
		System.out.println(s);
	}
}

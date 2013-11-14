package com.semkagtn.runtime;

public class RuntimeTest {
	public static void main(String[] args) {
		JSObject x = new JSString("abc");
		JSObject y = new JSFunction() {
			public JSObject call() {
				return JSUndef.UNDEF;
			}
		};
		System.out.println(x.add(y));
	}
}

package com.semkagtn.runtime;

import java.util.Scanner;

public abstract class JSFunction extends JSString {
	
	private static final String DEFAULT_TEXT = "[native code]";
	
	public static final JSFunction PRINT = new JSFunction(DEFAULT_TEXT) {
		public JSObject call(JSObject[] objects) {
			if (objects.length == 0) {
				System.out.print(JSUndef.UNDEF);
			} else {
				System.out.print(objects[0]);
			}
			return JSUndef.UNDEF;
		}
	};
	
	public static final JSFunction READ = new JSFunction(DEFAULT_TEXT) {
		private Scanner scanner = new Scanner(System.in);
		
		public JSObject call(JSObject... objects) {
			return new JSString(scanner.nextLine());
		}
	};
	
	public JSFunction(String text) {
		super(text);
	}
	
	public JSObject add(JSObject rhs) {
		return new JSString(value + rhs.value);
	}
	
	protected JSBool toJSBool() {
		return JSBool.TRUE;
	}

	protected JSNumber toJSNumber() {
		return JSNumber.NAN;
	}

}

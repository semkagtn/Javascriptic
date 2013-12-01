package com.semkagtn.javascriptic.runtime;

import java.util.Scanner;

public abstract class JSFunction extends JSString {
	
	private static final String DEFAULT_TEXT = "[native code]";
	
	public static final JSFunction PRINT = new JSFunction(DEFAULT_TEXT) {
		public JSObject call(JSObject[] objects) {
			if (objects.length == 0) {
				System.out.print(JSUndef.UNDEF);
			} else {
				System.out.print(objects[0].toJSString());
			}
			return JSUndef.UNDEF;
		}
	};
	
	public static final JSFunction READ = new JSFunction(DEFAULT_TEXT) {
		private Scanner scanner = new Scanner(System.in);
		
		public JSObject call(JSObject[] objects) {
			return new JSString(scanner.nextLine());
		}
	};
	
	public static final JSFunction ROUND = new JSFunction(DEFAULT_TEXT) {
		public JSObject call(JSObject[] objects) {
			if (objects.length == 0) {
				return JSNumber.NAN;
			}
			JSNumber n = objects[0].toJSNumber();
			if (n == JSNumber.NAN) {
				return JSNumber.NAN;
			}
			long res = Math.round(Double.parseDouble(n.value));
			return new JSNumber(res + "");
		}
	};
	
	public static final JSFunction LENGTH = new JSFunction(DEFAULT_TEXT) {
		public JSObject call(JSObject[] objects) {
			if (objects.length == 0) {
				return JSUndef.UNDEF;
			}
			return objects[0].length();
		}
	};
	
	public static final JSFunction RANDOM = new JSFunction(DEFAULT_TEXT) {
		public JSObject call(JSObject[] objects) {
			return new JSNumber(Math.random() + "");
		}
	};
	
	public JSFunction(String text) {
		super(text);
	}
	
	public JSObject add(JSObject rhs) {
		return new JSString(value + rhs.value);
	}
	
	public JSObject length() {
		return JSUndef.UNDEF;
	}
	
	protected JSBool toJSBool() {
		return JSBool.TRUE;
	}

	protected JSNumber toJSNumber() {
		return JSNumber.NAN;
	}
	
	public JSObject eq(JSObject rhs) {
		if (rhs instanceof JSFunction) {
			if (this == rhs) {
				return JSBool.TRUE;
			} else {
				return JSBool.FALSE;
			}
		}
		return super.eq(rhs);
	}
	
	public JSObject ne(JSObject rhs) {
		return eq(rhs).not();
	}

}

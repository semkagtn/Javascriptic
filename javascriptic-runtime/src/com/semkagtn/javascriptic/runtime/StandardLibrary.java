package com.semkagtn.javascriptic.runtime;

import java.util.Scanner;

public abstract class StandardLibrary {
	public static final JSArray CONSOLE;
	public static final JSArray MATH;
	
	private static final String FUNCTION_TEXT = "[native code]";

	private static final JSFunction CONSOLE_PRINT = new JSFunction(FUNCTION_TEXT) {
		public JSObject call(JSObject... objects) {
			if (objects.length == 0) {
				System.out.print(JSUndef.UNDEF);
			} else {
				System.out.print(objects[0].toJSString().value);
			}
			return JSUndef.UNDEF;
		}
	};
	
	private static final JSFunction CONSOLE_READ = new JSFunction(FUNCTION_TEXT) {
		private Scanner scanner = new Scanner(System.in);
		
		public JSObject call(JSObject... objects) {
			return new JSString(scanner.nextLine());
		}
	};
	
	private static final JSFunction MATH_ROUND = new JSFunction(FUNCTION_TEXT) {
		public JSObject call(JSObject... objects) {
			if (objects.length == 0) {
				return JSNumber.NAN;
			}
			JSObject n = objects[0].toJSNumber();
			if (n == JSNumber.NAN) {
				return JSNumber.NAN;
			}
			long res = Math.round(Double.parseDouble(n.value));
			return new JSNumber(res + "");
		}
	};
	
	private static final JSFunction MATH_FLOOR = new JSFunction(FUNCTION_TEXT) {
		public JSObject call(JSObject... objects) {
			if (objects.length == 0) {
				return JSNumber.NAN;
			}
			JSObject n = objects[0].toJSNumber();
			if (n == JSNumber.NAN) {
				return JSNumber.NAN;
			}
			long res = (long) Math.floor(Double.parseDouble(n.value));
			return new JSNumber(res + "");
		}
	};
	
	private static final JSFunction MATH_CEIL = new JSFunction(FUNCTION_TEXT) {
		public JSObject call(JSObject... objects) {
			if (objects.length == 0) {
				return JSNumber.NAN;
			}
			JSObject n = objects[0].toJSNumber();
			if (n == JSNumber.NAN) {
				return JSNumber.NAN;
			}
			long res = (long) Math.ceil(Double.parseDouble(n.value));
			return new JSNumber(res + "");
		}
	};
	
	private static final JSFunction MATH_RANDOM = new JSFunction(FUNCTION_TEXT) {
		public JSObject call(JSObject... objects) {
			return new JSNumber(Math.random() + "");
		}
	};
	
	static {
		CONSOLE = new JSArray();
		CONSOLE.put(new JSString("print"), CONSOLE_PRINT);
		CONSOLE.put(new JSString("read"), CONSOLE_READ);
		
		MATH = new JSArray();
		MATH.put(new JSString("random"), MATH_RANDOM);
		MATH.put(new JSString("round"), MATH_ROUND);
		MATH.put(new JSString("floor"), MATH_FLOOR);
		MATH.put(new JSString("ceil"), MATH_CEIL);
	}
}

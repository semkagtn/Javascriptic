package com.semkagtn.javascriptic.runtime;

import java.util.Scanner;

public abstract class StandardLibrary {
	public static final JSArray CONSOLE;
	public static final JSArray MATH;
	
	private static final String FUNCTION_TEXT = "[native code]";

	private static final JSFunction CONSOLE_PRINT = new JSFunction(FUNCTION_TEXT) {
		public JSObject call(JSObject... objects) {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < objects.length; i++) {
				result.append(objects[i].toJSString().value);
				if (i != objects.length - 1) {
					result.append(" ");
				}
			}
			System.out.print(result.toString());
			return JSUndef.UNDEF;
		}
	};
	
	private static final JSFunction CONSOLE_PRINTLN = new JSFunction(FUNCTION_TEXT) {
		public JSObject call(JSObject... objects) {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < objects.length; i++) {
				result.append(objects[i].toJSString().value);
				if (i != objects.length - 1) {
					result.append(" ");
				}
			}
			System.out.println(result.toString());
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
			long res = Math.round(n.number);
			return new JSNumber(res);
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
			long res = (long) Math.floor(n.number);
			return new JSNumber(res);
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
			long res = (long) Math.ceil(n.number);
			return new JSNumber(res);
		}
	};
	
	private static final JSFunction MATH_RANDOM = new JSFunction(FUNCTION_TEXT) {
		public JSObject call(JSObject... objects) {
			return new JSNumber(Math.random());
		}
	};
	
	private static final JSFunction MATH_MIN = new JSFunction(FUNCTION_TEXT) {
		public JSObject call(JSObject... objects) {
			if (objects.length == 0) {
				return JSUndef.UNDEF;
			}
			JSObject min = objects[0].toJSNumber();
			for (int i = 1; i < objects.length; i++) {
				JSObject o = objects[i].toJSNumber();
				if (o.lt(min) == JSBool.TRUE) {
					min = o;
				}
			}
			return min;
		}
	};
	
	private static final JSFunction MATH_MAX = new JSFunction(FUNCTION_TEXT) {
		public JSObject call(JSObject... objects) {
			if (objects.length == 0) {
				return JSUndef.UNDEF;
			}
			JSObject max = objects[0].toJSNumber();
			for (int i = 1; i < objects.length; i++) {
				JSObject o = objects[i].toJSNumber();
				if (o.gt(max) == JSBool.TRUE) {
					max = o;
				}
			}
			return max;
		}
	};
	
	static {
		CONSOLE = new JSArray();
		CONSOLE.put(new JSString("print"), CONSOLE_PRINT);
		CONSOLE.put(new JSString("println"), CONSOLE_PRINTLN);
		CONSOLE.put(new JSString("read"), CONSOLE_READ);
		
		MATH = new JSArray();
		MATH.put(new JSString("random"), MATH_RANDOM);
		MATH.put(new JSString("round"), MATH_ROUND);
		MATH.put(new JSString("floor"), MATH_FLOOR);
		MATH.put(new JSString("ceil"), MATH_CEIL);
		MATH.put(new JSString("min"), MATH_MIN);
		MATH.put(new JSString("max"), MATH_MAX);
	}
}

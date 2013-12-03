package com.semkagtn.javascriptic.runtime;
import java.util.Scanner;

public abstract class JSFunction extends JSObject {
	private static final String DEFAULT_TEXT = "[native code]";

	public static final JSFunction PRINT = new JSFunction(DEFAULT_TEXT) {
		public JSObject call(JSObject[] objects) {
			if (objects.length == 0) {
				System.out.print(JSUndef.UNDEF);
			} else {
				System.out.print(objects[0].toJSString().value);
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
			JSObject n = objects[0].toJSNumber();
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
	
	protected JSObject toJSPrimitive(Type hint) {
		if (hint == Type.NUMBER) {
			return JSNumber.NAN;
		}
		return new JSString(value);
	}
	
	public JSFunction(String text) {
		super(Type.OBJECT, text);
	}
}

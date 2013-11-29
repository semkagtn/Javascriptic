package com.semkagtn.runtime;

public abstract class JSFunction extends JSString {
	
	private static final String DEFAULT_TEXT = "[native code]";
	
	public static final JSFunction PRINT = new JSFunction(DEFAULT_TEXT) {
		public JSObject call(JSObject... objects) {
			if (objects.length == 0) {
				System.out.print(JSUndef.UNDEF);
			} else if (objects[0] instanceof JSNumber) {
				String number = objects[0].value;
				int t = number.length() - 2;
				if (number.substring(t).equals(".0")) {
					System.out.print(number.substring(0, t));
				} else {
					System.out.print(number);
				}
			} else {
				System.out.print(objects[0]);
			}
			return JSUndef.UNDEF;
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

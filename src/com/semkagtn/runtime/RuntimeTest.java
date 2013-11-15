package com.semkagtn.runtime;

public class RuntimeTest {
	
	/*
	 *    function() {
	 *    	var x;
	 *    	var f2 = function() {
	 *    		var y = false;
	 *    		print(x); // undefined
	 *    		var f3 = function() {
	 *    			print("" + x + y); // undefinedfalse
	 *    		};
	 *    		f3();
	 *    	};
	 *    	f2();
	 *    }();
	 */
	
	public static void main(String[] args) {
		new JSFunction("function") {
			public JSObject call(JSObject... objects) {
				final Scope scope = new Scope();
				scope.x = JSUndef.UNDEF;
				JSObject f2 = new JSFunction("function") {
					public JSObject call(JSObject... objects) {
						final Scope scope2 = new Scope();
						scope2.x = JSBool.FALSE;
						System.out.println(scope.x);
						JSObject f3 = new JSFunction("function") {
							public JSObject call(JSObject... objects) {
								System.out.println(JSString.EMPTY.add(scope.x).add(scope2.x));
								return JSUndef.UNDEF;
							}
						};
						f3.call();
						return JSUndef.UNDEF;
					}
				};
				f2.call();
				return JSUndef.UNDEF;
			}
		}.call();
	}
}

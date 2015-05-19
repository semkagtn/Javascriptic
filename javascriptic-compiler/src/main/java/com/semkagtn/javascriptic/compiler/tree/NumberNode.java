package com.semkagtn.javascriptic.compiler.tree;

import com.semkagtn.javascriptic.compiler.visitor.AstVisitor;
import com.semkagtn.javascriptic.runtime.JSNumber;
import com.semkagtn.javascriptic.runtime.JSObject;

public class NumberNode extends ConstantNode {
	public void setValue(String value) {
		try {
			double t = Double.parseDouble(value);
			String str = (long) t == t ? "" + (long) t : "" + t;
			super.setValue(str);
		} catch (NumberFormatException e) {
			super.setValue(value); // NaN
		}
	}

    @Override
    public JSObject toJSObject() {
        if (getValue().equals("Infinity")) {
            return JSNumber.POS_INFINITY;
        }
        try {
            double value = Double.parseDouble(getValue());
            return new JSNumber(value);
        } catch (NumberFormatException e) {
        }
        return JSNumber.NAN;
    }

    public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

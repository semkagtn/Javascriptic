package com.semkagtn.javascriptic.compiler.tree;

import com.semkagtn.javascriptic.compiler.visitor.AstVisitor;
import com.semkagtn.javascriptic.runtime.JSObject;
import com.semkagtn.javascriptic.runtime.JSString;

public class StringNode extends ConstantNode {
	public void setValue(String value) {
		super.setValue(value
				.substring(1, value.length() - 1)
				.replace("\\\"", "\"")
				.replace("\\\\", "\\")
				.replace("\\b", "\b")
				.replace("\\f", "\f")
				.replace("\\n", "\n")
				.replace("\\r", "\r")
				.replace("\\t", "\t"));
	}

    @Override
    public JSObject toJSObject() {
        return new JSString(getValue());
    }

    public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}
}

package com.semkagtn.javascriptic.compiler.tree;

import com.semkagtn.javascriptic.compiler.visitor.AstVisitor;
import com.semkagtn.javascriptic.runtime.JSBool;
import com.semkagtn.javascriptic.runtime.JSObject;

public class BoolNode extends ConstantNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}

    @Override
    public JSObject toJSObject() {
        return JSBool.fromString(getValue());
    }
}

package com.semkagtn.javascriptic.compiler.tree;

import com.semkagtn.javascriptic.compiler.visitor.AstVisitor;
import com.semkagtn.javascriptic.runtime.JSObject;
import com.semkagtn.javascriptic.runtime.JSUndef;

public class UndefNode extends ConstantNode {
	public <T> T accept(AstVisitor<T> v) {
		return v.visit(this);
	}

    @Override
    public JSObject toJSObject() {
        return JSUndef.UNDEF;
    }
}

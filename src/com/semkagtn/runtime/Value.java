package com.semkagtn.runtime;

public abstract class Value {
	protected Object value;
	protected Type type;
	
	public abstract Value not();
	public abstract Value neg();
	public abstract Value mul(Value rhs);
	public abstract Value div(Value rhs);
	public abstract Value mod(Value rhs);
	public abstract Value add(Value rhs);
	public abstract Value sub(Value rhs);
	public abstract Value lt(Value rhs);
	public abstract Value le(Value rhs);
	public abstract Value gt(Value rhs);
	public abstract Value ge(Value rhs);
	public abstract Value eq(Value rhs);
	public abstract Value ne(Value rhs);
	public abstract Value and(Value rhs);
	public abstract Value or(Value rhs);
}

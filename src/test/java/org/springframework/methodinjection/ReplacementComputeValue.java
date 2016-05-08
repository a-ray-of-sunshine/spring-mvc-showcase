package org.springframework.methodinjection;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class ReplacementComputeValue implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {

		String input = (String) args[0];
		input += ": ReplacementComputeValue";

		return input;
	}
}

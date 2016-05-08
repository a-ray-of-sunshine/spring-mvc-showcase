package org.springframework.methodinjection;

public class MyValueCalculator {

	public String computeValue(String input){
		input += ": MyValueCalculator";
		return input;
	}
}

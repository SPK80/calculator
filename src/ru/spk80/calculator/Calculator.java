package ru.spk80.calculator;

public class Calculator {
	private String input;

	public Calculator(String input) {
		this.input = input;
	}

	public String calc() {
		return "Result of " + this.input;
	}

}

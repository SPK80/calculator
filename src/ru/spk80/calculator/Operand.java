package ru.spk80.calculator;

public abstract class Operand {

	int value;

	public Operand(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public abstract String getString() throws Exception;
}
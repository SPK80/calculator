package ru.spk80.calculator;

public class Operand {
	private boolean isRoman = false;
	private int value;

	public Operand(String strOperand) {

	}

	public Operand(int intOperand) {

	}

	public Boolean isRoman() {
		return this.isRoman;
	}

	public String toRoman() {
		return null;
	}

	public int toInt() {
		return 0;
	}

}

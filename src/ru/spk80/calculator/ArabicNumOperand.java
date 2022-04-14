package ru.spk80.calculator;

class ArabicNumOperand extends Operand {

	public ArabicNumOperand(int value) {
		super(value);
	}

	@Override
	public String getString() {
		return Integer.toString(value);
	}

}

package ru.spk80.calculator;

public class RomanNumOperand extends Operand {

	public RomanNumOperand(String strValue) throws Exception {
		super(Roman.toInt(strValue));
	}

	public RomanNumOperand(int value) {
		super(value);
	}

	@Override
	public String getString() throws Exception {
		return Roman.toRoman(value);
	}
}
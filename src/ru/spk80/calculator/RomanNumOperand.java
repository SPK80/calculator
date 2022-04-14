package ru.spk80.calculator;

class RomanNumOperand extends Operand {

	public RomanNumOperand(String strValue) throws Exception {
		super(Roman.toInt(strValue));
	}

	public RomanNumOperand(int value) throws Exception {
		super(value);
		if (value < 1)
			throw new Exception("Roman nums must be greater than zero");
	}

	@Override
	public String getString() throws Exception {
		return Roman.toRoman(value);
	}
}
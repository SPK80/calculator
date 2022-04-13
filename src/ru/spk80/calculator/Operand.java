package ru.spk80.calculator;

public class Operand {
	private final boolean isRoman;
	private final int value;

	public Operand(String strValue) throws Exception {
		if (strValue == null || strValue == "")
			throw new Exception("Invalid operand!");

		int _value;
		boolean _isRoman;
		try {
			_value = Integer.parseInt(strValue);
			_isRoman = false;
		} catch (NumberFormatException e) {
			_value = Roman.toInt(strValue.trim());
			_isRoman = true;
		}
		value = _value;
		isRoman = _isRoman;
	}

	public Operand(int intValue) {
		value = intValue;
		isRoman = false;
	}

	public Boolean isRoman() {
		return this.isRoman;
	}

	public String toRoman() throws Exception {
		return Roman.toRoman(value);
	}

	public int toInt() {
		return value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}

}

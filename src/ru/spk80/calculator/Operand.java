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
			_value = parseRoman(strValue.trim());
			_isRoman = true;
		}
		value = _value;
		isRoman = _isRoman;
	}

	private final String[] romanNums = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };

	private int parseRoman(String strValue) throws Exception {
		var l = romanNums.length;
		var i = 0;

		while (romanNums[i] != strValue && i++ < l) {
		}

		if (i < 1 || i >= l)
			throw new Exception("Invalid Roman number!");
		return i;
	}

	public Operand(int intValue) {
		value = intValue;
		isRoman = false;
	}

	public Boolean isRoman() {
		return this.isRoman;
	}

	public String toRoman() {
		return romanNums[value];
	}

	public int toInt() {
		return value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}

}

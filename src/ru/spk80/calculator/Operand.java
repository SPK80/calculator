package ru.spk80.calculator;

public class Operand {
	private boolean isRoman = false;
	private int value;

	public Operand(String strValue) throws Exception {
		value = fromRoman(strValue.trim());
	}

	private final String[] romanNums = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };

	private int fromRoman(String strValue) throws Exception {
		var l = romanNums.length;
		var i = 0;

		while (romanNums[i] != strValue && i++ < l) {
		}

		if (i < 1 || i >= l)
			throw new Exception("Invalid Roman number!");
		isRoman = true;
		return i;
	}

	public Operand(int intValue) {
		value = intValue;
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

}

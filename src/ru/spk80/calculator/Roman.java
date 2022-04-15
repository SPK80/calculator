package ru.spk80.calculator;

class Roman {

	private static final String[] nums = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };
	private static final String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C" };

	public static int toInt(String strValue) throws Exception {

		int l = nums.length;
		int i = 0;

		while (!strValue.equals(nums[i]) && i++ < l - 1) {
		}

		if (i < 1 || i >= l)
			throw new Exception("Invalid value " + strValue);

		return i;
	}

	public static String toRoman(int value) throws Exception {

		if (value < 1 || value > 100)
			throw new Exception("Value " + value + " out of range");

		int ten = value / 10;
		return tens[ten] + nums[value % 10];
	}
}
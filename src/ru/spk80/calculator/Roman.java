package ru.spk80.calculator;

public class Roman {
	private final String[] nums = { "N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
	private final String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C" };

	String toRoman(int value) throws Exception {
		if (value < 1 || value > 100)
			throw new Exception("Invalid value!");
		var ten = value / 10;

		return tens[ten] + nums[value];
	}

}
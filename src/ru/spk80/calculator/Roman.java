package ru.spk80.calculator;

public class Roman {
	private static final String[] nums = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
	private static final String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C" };

	public static String toRoman(int value) throws Exception {
		if (value < 1 || value > 100)
			throw new Exception("Invalid value: " + value);
		var ten = value / 10;

		return tens[ten] + nums[value % 10];
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 101; i++) {
			try {
				System.out.println(i + toRoman(i));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
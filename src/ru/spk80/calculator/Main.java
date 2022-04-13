package ru.spk80.calculator;

import java.util.Scanner;

class Main {

	public static String calc(String input) throws Exception {
		var expression = new Expression(input);
		var result = expression.calc();
		return result;
	}

	public static void main(String[] args) {

		try (var scanner = new Scanner(System.in)) {
			String input;
			while (true) {
				input = scanner.nextLine();
				try {
					System.out.println(calc(input));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
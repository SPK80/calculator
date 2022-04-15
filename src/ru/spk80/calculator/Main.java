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

			var input = scanner.nextLine();
			var result = calc(input);
			System.out.println(result);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

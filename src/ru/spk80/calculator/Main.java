package ru.spk80.calculator;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		try (var scanner = new Scanner(System.in)) {
			String input;
			while (true) {
				input = scanner.nextLine();
				try {
					var expression = new Expression(input);
					var result = expression.calc();
					System.out.println(result);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}
	}
}
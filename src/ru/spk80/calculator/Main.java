package ru.spk80.calculator;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		try {
			String input;
			while (true) {
				input = scanner.nextLine();
				var expression = new Expression(input);
				var result = expression.calc();
				System.out.println(result);
			}

		} catch (Exception e) {

		} finally {
			scanner.close();
		}
	}

}
package ru.spk80.calculator;

public class Parser {

	private final char[] operators = { '+', '-', '*', '/' };
	private final Operator operator;
	private final Operand leftOperand;
	private final Operand rightOperand;

	private Operator createOperator(char operatorSymbol) throws Exception {
		switch (operatorSymbol) {
			case '+':
				return new SumOperator();
			case '-':
				return new SubOperator();
			case '*':
				return new MulOperator();
			case '/':
				return new DivOperator();
			default:
				throw new Exception("Operator not found!");
		}
	}

	private int findOperatorPos(String expression) throws Exception {
		int i = 0;
		int pos = -1;
		do {
			pos = expression.indexOf(operators[i++]);
		} while (pos < 0 && i < operators.length);

		if (pos < 0 || pos >= operators.length)
			throw new Exception("Operator not found!");
		return pos;
	}

	private Operand createOperand(String strValue) throws Exception {

		if (strValue == null || strValue == "")
			throw new Exception("Operand is empty");

		try {
			int value = Integer.parseInt(strValue);
			return new ArabicNumOperand(value);
		} catch (NumberFormatException e) {
			return new RomanNumOperand(strValue);
		}
	}

	private Operand createLeftOperand(String expression, int operatorPos) throws Exception {
		return createOperand(expression.substring(0, operatorPos).trim());
	}

	private Operand createRightOperand(String expression, int operatorPos) throws Exception {
		return createOperand(expression.substring(operatorPos + 1, expression.length()).trim());
	}

	public Parser(String expression) throws Exception {

		var operatorPos = findOperatorPos(expression);
		operator = createOperator(expression.charAt(operatorPos));
		leftOperand = createLeftOperand(expression, operatorPos);
		rightOperand = createRightOperand(expression, operatorPos);
	}

	public Operator getOperator() {
		return operator;
	}

	public Operand getLeftOperand() {
		return leftOperand;
	}

	public Operand getRightOperand() {
		return rightOperand;
	}

}

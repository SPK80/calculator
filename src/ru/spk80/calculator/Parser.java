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

	private Operand createLeftOperand(String expression, int operatorPos) throws Exception {
		return new Operand(expression.substring(0, operatorPos));
	}

	private Operand createRightOperand(String expression, int operatorPos) throws Exception {
		return new Operand(expression.substring(operatorPos + 1, expression.length()));
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

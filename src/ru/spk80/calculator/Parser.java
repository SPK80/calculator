package ru.spk80.calculator;

public class Parser {

	private final char[] operators = { '+', '-', '*', '/' };
	private final Operator operator;
	private final Operand leftOperand;
	private final Operand rightOperand;

	private char findOperator(String expression) throws Exception {
		int i = 0;
		int pos = -1;
		do {
			pos = expression.indexOf(operators[i++]);
		} while (pos < 0 || i < operators.length - 1);

		if (pos < 0 || pos >= operators.length)
			throw new Exception("Operator not found!");
		return expression.charAt(pos);
	}

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

	private Operand[] createOperands(String expression, char operatorSymbol) throws Exception {
		var operands = expression.split("" + operatorSymbol);
		if (operands.length != 2)
			throw new Exception("Wrong number of operands!");
		return new Operand[] { new Operand(operands[0]), new Operand(operands[1]) };
	}

	public Parser(String expression) throws Exception {

		var operatorSymbol = findOperator(expression);
		operator = createOperator(operatorSymbol);

		var operands = createOperands(expression, operatorSymbol);
		leftOperand = operands[0];
		rightOperand = operands[1];
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

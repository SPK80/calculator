package ru.spk80.calculator;

class Parser {

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

	private int findOperatorPos(String exprStr) throws Exception {
		int i = 0;
		int pos = -1;
		do {
			pos = exprStr.indexOf(operators[i++]);
		} while (pos < 0 && i < operators.length);
		return pos;
	}

	private Operand createOperand(String strValue) throws Exception {

		if (strValue == null || strValue == "")
			throw new Exception("Operand is empty");

		if (findOperatorPos(strValue) >= 0)
			throw new Exception("Incorrect operand " + strValue);

		try {

			int value = Integer.parseInt(strValue);
			if (value < 1 || value > 10)
				throw new Exception("Input value " + value + " out of range");
			return new ArabicNumOperand(value);

		} catch (NumberFormatException nfe) {
			try {
				return new RomanNumOperand(strValue);
			} catch (Exception e) {
				throw new Exception("Invalid input value " + strValue);
			}
		}
	}

	private Operand createLeftOperand(String exprStr, int operatorPos) throws Exception {
		return createOperand(exprStr.substring(0, operatorPos).trim());
	}

	private Operand createRightOperand(String exprStr, int operatorPos) throws Exception {
		return createOperand(exprStr.substring(operatorPos + 1, exprStr.length()).trim());
	}

	public Parser(String exprStr) throws Exception {

		var operatorPos = findOperatorPos(exprStr);
		if (operatorPos < 0)
			throw new Exception("Operator not found!");

		operator = createOperator(exprStr.charAt(operatorPos));
		leftOperand = createLeftOperand(exprStr, operatorPos);
		rightOperand = createRightOperand(exprStr, operatorPos);
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

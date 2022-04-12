package ru.spk80.calculator;

public class Expression {
	private Parser parser;

	public Expression(String expression) throws Exception {
		parser = new Parser(expression);
	}

	public String calc() throws Exception {
		var operator = parser.getOperator();
		var leftOperand = parser.getLeftOperand();
		var rightOperand = parser.getRightOperand();

		var isRoman = leftOperand.isRoman();
		if (isRoman != rightOperand.isRoman())
			throw new Exception("Incorrect operands!");

		Operand result = operator.ApplyTo(leftOperand, rightOperand);
		return isRoman ? result.toRoman() : result.toString();
	}

}

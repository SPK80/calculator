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

		Operand result = operator.applyTo(leftOperand, rightOperand);
		return result.getString();
	}

}

package ru.spk80.calculator;

class Expression {
	private Parser parser;

	public Expression(String str) throws Exception {
		parser = new Parser(str);
	}

	public String calc() throws Exception {
		var operator = parser.getOperator();
		var leftOperand = parser.getLeftOperand();
		var rightOperand = parser.getRightOperand();

		Operand result = operator.applyTo(leftOperand, rightOperand);
		
		return result.getString();
	}

}

package ru.spk80.calculator;

abstract class Operator {

	protected abstract int operation(int leftValue, int rightValue);

	public Operand applyTo(Operand leftOperand, Operand rightOperand) throws Exception {

		if (leftOperand.getClass() != rightOperand.getClass())
			throw new Exception("Operands of different types");

		var result = operation(leftOperand.getValue(), rightOperand.getValue());

		if (leftOperand instanceof RomanNumOperand)
			return new RomanNumOperand(result);
		else if (leftOperand instanceof ArabicNumOperand)
			return new ArabicNumOperand(result);
		else
			throw new Exception("Anknow class of operand");
	}
}
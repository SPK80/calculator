package ru.spk80.calculator;

public abstract class Operator {

	protected abstract int operation(int leftValue, int rightValue);

	public Operand applyTo(Operand leftOperand, Operand rightOperand) throws Exception {

		var result = operation(leftOperand.getValue(), rightOperand.getValue());

		if (leftOperand instanceof RomanNumOperand)
			return new RomanNumOperand(result);
		else if (leftOperand instanceof ArabicNumOperand)
			return new ArabicNumOperand(result);
		else
			throw new Exception("Anknow class of operand");
	}
}
package ru.spk80.calculator;

public class MulOperator implements Operator {

	@Override
	public Operand ApplyTo(Operand leftOperand, Operand rightOperand) throws Exception {

		var result = leftOperand.getValue() * rightOperand.getValue();

		if (leftOperand instanceof RomanNumOperand)
			return new RomanNumOperand(result);
		else if (leftOperand instanceof ArabicNumOperand)
			return new ArabicNumOperand(result);
		else
			throw new Exception("");
	}
}
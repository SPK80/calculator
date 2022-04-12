package ru.spk80.calculator;

public class MulOperator implements Operator {

	@Override
	public Operand ApplyTo(Operand leftOperand, Operand rightOperand) {
		return new Operand(leftOperand.toInt() * rightOperand.toInt());
	}
}
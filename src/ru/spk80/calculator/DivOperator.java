package ru.spk80.calculator;

class DivOperator extends Operator {
	@Override
	protected int operation(int leftValue, int rightValue) {
		return leftValue / rightValue;
	}
}
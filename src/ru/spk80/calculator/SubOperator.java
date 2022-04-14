package ru.spk80.calculator;

class SubOperator extends Operator {
	@Override
	protected int operation(int leftValue, int rightValue) {
		return leftValue - rightValue;
	}
}
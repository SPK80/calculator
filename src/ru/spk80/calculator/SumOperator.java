package ru.spk80.calculator;

public class SumOperator extends Operator {
	@Override
	protected int operation(int leftValue, int rightValue) {
		return leftValue + rightValue;
	}
}
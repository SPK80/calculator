package ru.spk80.calculator;

public interface Operator {
	public abstract Operand ApplyTo(Operand leftOperand, Operand rightOperand);
}
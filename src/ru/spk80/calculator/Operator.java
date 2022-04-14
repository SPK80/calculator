package ru.spk80.calculator;

public abstract class Operator {

	public abstract Operand ApplyTo(Operand leftOperand, Operand rightOperand) throws Exception;
	
}
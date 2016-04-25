package com.seavus;

public class Calculation {

	private int firstOperand;
	private int secondOperand;
	private int result;
	private String operator;

	public Calculation(int firstOperand, int secondOperand, String operator) {
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
		this.operator = operator;
		if (operator.equals("PLUS")) {
			result = firstOperand + secondOperand;
		} else if (operator.equals("MINUS")) {
			result = firstOperand - secondOperand;
		}
	}

	public int getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(int firstOperand) {
		this.firstOperand = firstOperand;
	}

	public int getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(int secondOperand) {
		this.secondOperand = secondOperand;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String toString() {
		String calculation = "";
		if (operator.equals("PLUS")) {
			calculation = firstOperand + " + " + secondOperand + " = " + result;
		} else if (operator.equals("MINUS")) {
			calculation = firstOperand + " - " + secondOperand + " = " + result;
		}
		return calculation;
	}

}

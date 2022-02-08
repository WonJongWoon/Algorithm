package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/08
// Problem : https://programmers.co.kr/learn/courses/30/lessons/67257

import java.util.ArrayDeque;

class Solution67257 {

	private final static int[][] orders = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

	private int orderOf(int[] order, char operation) {
		return order[operationIndex(operation)];
	}

	private int operationIndex(char operation) {
		switch (operation) {
			case '+':
				return 0;
			case '-':
				return 1;
			case '*':
				return 2;
			default:
				return -1;
		}
	}

	private boolean isOperator(char operator) {
		return (operator == '+' || operator == '-' || operator == '*');
	}

	private ArrayDeque<Long> infixToPostfix(String expression, int[] order) {
		ArrayDeque<Long> postfix = new ArrayDeque<>();
		ArrayDeque<Character> operators = new ArrayDeque<>();

		char[] chars = expression.toCharArray();

		int start = 0;
		for (int i = 0; i < chars.length; i++) {
			if (!isOperator(chars[i])) {
				continue;
			}

			postfix.offerLast(Long.parseLong(expression.substring(start, i)));

			char operator = chars[i];
			while (!operators.isEmpty() && (orderOf(order, operators.peek()) >= orderOf(order, operator))) {
				postfix.offerLast((long)operators.pop());
			}
			operators.push(operator);
			start = i + 1;
		}

		postfix.offerLast(Long.parseLong(expression.substring(start)));

		while (!operators.isEmpty()) {
			postfix.offerLast((long)operators.pop());
		}

		return postfix;
	}

	private long solve(String expression, int[] order) {
		return calculate(infixToPostfix(expression, order));
	}

	private long doOperation(char operator, long operand1, long operand2) {
		switch (operator) {
			case '+':
				return operand1 + operand2;
			case '-':
				return operand1 - operand2;
			case '*':
				return operand1 * operand2;
			default:
				return 0;
		}
	}

	private long calculate(ArrayDeque<Long> postfix) {
		ArrayDeque<Long> numbers = new ArrayDeque<>();

		for (long v : postfix) {
			if (isOperator((char)v)) {
				long operand2 = numbers.pop();
				long operand1 = numbers.pop();
				numbers.push(doOperation((char)v, operand1, operand2));
			} else {
				numbers.push(v);
			}
		}

		return Math.abs(numbers.pop());
	}

	public long solution(String expression) {
		long result = -1;
		for (int[] order : orders) {
			result = Math.max(result, solve(expression, order));
		}

		return result;
	}
}

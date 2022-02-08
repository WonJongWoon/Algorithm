package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/08
// Problem : https://programmers.co.kr/learn/courses/30/lessons/67257

import java.util.ArrayDeque;

class Solution67257 {

	private final static int[][] orders = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

	private static abstract class Expression {

	}

	private static class Number extends Expression {

		private final Long value;

		public Number(Long value) {
			this.value = value;
		}

		public long value() {
			return value;
		}
	}

	private static class Operator extends Expression {

		private final int[] priorities;
		private final char operator;

		public Operator(char operator, int[] priorities) {
			this.operator = operator;
			this.priorities = priorities;
		}

		private int index() {
			switch (operator) {
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

		public static boolean isValid(char operator) {
			return (operator == '+' || operator == '-' || operator == '*');
		}

		public long calculate(long operand1, long operand2) {
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

		public int priority() {
			return priorities[index()];
		}
	}

	private ArrayDeque<Expression> infixToPostfix(String expression, int[] priorities) {
		ArrayDeque<Expression> postfix = new ArrayDeque<>();
		ArrayDeque<Operator> operators = new ArrayDeque<>();

		int start = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (!Operator.isValid(expression.charAt(i))) {
				continue;
			}

			postfix.offerLast(new Number(Long.parseLong(expression.substring(start, i))));

			Operator operator = new Operator(expression.charAt(i), priorities);
			while (!operators.isEmpty() && (operators.peek().priority() >= operator.priority())) {
				postfix.offerLast(operators.pop());
			}
			operators.push(operator);

			start = i + 1;
		}

		postfix.offerLast(new Number(Long.parseLong(expression.substring(start))));

		while (!operators.isEmpty()) {
			postfix.offerLast(operators.pop());
		}

		return postfix;
	}

	private long calculate(ArrayDeque<Expression> postfix) {
		ArrayDeque<Long> numbers = new ArrayDeque<>();

		for (Expression expression : postfix) {
			if (expression instanceof Operator) {
				Operator operator = (Operator)expression;
				long operand2 = numbers.pop();
				long operand1 = numbers.pop();
				numbers.push(operator.calculate(operand1, operand2));
			} else {
				Number value = (Number)expression;
				numbers.push(value.value());
			}
		}

		return Math.abs(numbers.pop());
	}

	private long solve(String expression, int[] priorities) {
		return calculate(infixToPostfix(expression, priorities));
	}

	public long solution(String expression) {
		long result = -1;
		for (int[] priorities : orders) {
			result = Math.max(result, solve(expression, priorities));
		}

		return result;
	}
}

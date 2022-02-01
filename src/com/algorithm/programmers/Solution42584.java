package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/01
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42584

import java.util.ArrayDeque;

class Solution42584 {

	public int[] solution(int[] prices) {
		int[] result = new int[prices.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				result[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			result[stack.peek()] = prices.length - stack.peek() - 1;
			stack.pop();
		}

		return result;
	}
}

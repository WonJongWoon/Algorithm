package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/09
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12909

import java.util.ArrayDeque;

class Solution12909 {

	public boolean solution(String s) {
		char[] chars = s.toCharArray();
		ArrayDeque<String> stack = new ArrayDeque<>();

		for (char v : chars) {
			if (v == ')') {
				if (!stack.isEmpty() && stack.peekLast().equals("(")) {
					stack.pollLast();
					continue;
				}

				return false;
			}

			stack.offerLast(String.valueOf(v));
		}

		return stack.isEmpty() ? true : false;
	}
}

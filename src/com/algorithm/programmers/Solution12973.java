package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/27
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12973

import java.util.ArrayDeque;

class Solution12973 {

	public int solution(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.getLast() == c) {
				stack.pollLast();
			} else {
				stack.offerLast(c);
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}
}

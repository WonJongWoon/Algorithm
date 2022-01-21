package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/21
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12899

class Solution12899 {

	public String solution(int n) {
		String[] symbols = {"4", "1", "2"};
		StringBuilder result = new StringBuilder();

		while (n > 0) {
			int remainder = n % 3;
			n /= 3;

			if (remainder == 0) {
				n--;
			}

			result.append(symbols[remainder]);
		}

		return result.reverse().toString();
	}
}

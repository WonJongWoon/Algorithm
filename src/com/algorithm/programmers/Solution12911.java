package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/15
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12911

class Solution12911 {

	private static int ones(int n) {
		int result = 0;

		while (n != 0) {
			result += (n & 1);
			n >>= 1;
		}

		return result;
	}

	public int solution(int n) {
		int base = ones(n);

		for (int i = n + 1; i <= 2 * n; i++) {
			if (ones(i) == base) {
				return i;
			}
		}

		return -1;
	}
}

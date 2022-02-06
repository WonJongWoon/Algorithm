package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/77885

class Solution77885 {

	private boolean isTurnOn(long n, int pos) {
		return (n & (1L << pos)) != 0;
	}

	private long turnOn(long n, int pos) {
		return n | (1L << pos);
	}

	private long turnOff(long n, int pos) {
		return n & (~(1L << pos));
	}

	private long solve(long n) {
		if ((n & 1L) == 0) {
			return n + 1;
		}

		for (int pos = 0; pos < 50; pos++) {
			if (!isTurnOn(n, pos)) {
				return turnOff(turnOn(n, pos), pos - 1);
			}
		}

		return n;
	}

	public long[] solution(long[] numbers) {
		long[] result = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			result[i] = solve(numbers[i]);
		}

		return result;
	}
}

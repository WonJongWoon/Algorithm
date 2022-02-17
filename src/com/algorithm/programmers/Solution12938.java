package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/17
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12938

import java.util.Arrays;

class Solution12938 {

	public int[] solution(int n, int s) {
		if (n > s) {
			return new int[] {-1};
		}

		int[] result = new int[n];
		Arrays.fill(result, s / n);

		for (int i = 0; i < (s % n); i++) {
			result[i]++;
		}

		Arrays.sort(result);
		return result;
	}
}

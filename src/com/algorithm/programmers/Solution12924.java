package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/07
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12924

class Solution12924 {

	public int solution(int n) {
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] + i;
		}

		int result = 0;

		int left = 0, right = 1;

		while (right <= n) {
			int v = dp[right] - dp[left];
			if (v == n) {
				left++;
				right--;
				result++;
			} else if (v < n) {
				right++;
			} else {
				left++;
			}
		}

		return result;
	}
}

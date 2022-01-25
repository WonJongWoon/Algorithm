package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/25
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12914

class Solution12914 {

	private static final int MOD = 1234567;

	private static long mod(long a, long b) {
		return ((a % MOD) + (b % MOD)) % MOD;
	}

	public long solution(int n) {
		if (n == 1) {
			return 1;
		}

		long[] dp = new long[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = mod(dp[i - 1], dp[i - 2]);
		}

		return dp[n];
	}
}

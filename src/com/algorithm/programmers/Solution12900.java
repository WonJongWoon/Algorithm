package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/19
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12900

class Solution12900 {

	private static final int MOD = 1_000_000_007;

	private static int mod(int a, int b) {
		return ((a % MOD) + (b % MOD)) % MOD;
	}

	public int solution(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = mod(dp[i - 1], dp[i - 2]);
		}

		return dp[n];
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/26
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12907

class Solution12907 {

	private static final int MOD = 1_000_000_007;

	private int mod(int a, int b) {
		return ((a % MOD) + (b % MOD)) % MOD;
	}

	public int solution(int n, int[] moneys) {
		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int money : moneys) {
			for (int k = money; k <= n; k++) {
				dp[k] = mod(dp[k], dp[k - money]);
			}
		}

		return dp[n];
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/12
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12913

class Solution12913 {

	public int solution(int[][] land) {
		int N = land.length;
		int[][] dp = new int[N][4];

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < 4; col++) {
				dp[row][col] = land[row][col];
			}
		}

		for (int i = 1; i < N; i++) {
			dp[i][0] += Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]);
			dp[i][1] += Math.max(Math.max(dp[i - 1][0], dp[i - 1][2]), dp[i - 1][3]);
			dp[i][2] += Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][3]);
			dp[i][3] += Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
		}

		return Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), Math.max(dp[N - 1][2], dp[N - 1][3]));
	}
}

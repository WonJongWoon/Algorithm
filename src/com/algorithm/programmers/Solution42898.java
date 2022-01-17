package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/17
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42898

class Solution42898 {

	private int mod(int a, int b) {
		return (a % 1_000_000_007 + b % 1_000_000_007) % 1_000_000_007;
	}

	public int solution(int m, int n, int[][] puddles) {
		int[][] dp = new int[n][m];
		dp[0][0] = 1;

		for (int[] puddle : puddles) {
			int x = puddle[0] - 1;
			int y = puddle[1] - 1;
			dp[y][x] = -1;
		}

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {

				if ((x == 0 && y == 0) || dp[y][x] == -1) {
					continue;
				}

				if (y - 1 >= 0 && dp[y - 1][x] != -1) {
					dp[y][x] = mod(dp[y][x], dp[y - 1][x]);
				}

				if (x - 1 >= 0 && dp[y][x - 1] != -1) {
					dp[y][x] = mod(dp[y][x], dp[y][x - 1]);
				}
			}
		}

		return dp[n - 1][m - 1] % 1_000_000_007;
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/03
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12942

import java.util.Arrays;

class Solution12942 {

	private static final int INF = 987654321;

	public int solution(int[][] matrixSizes) {
		int length = matrixSizes.length;
		int[][] dp = new int[length][length];

		for (int i = 0; i < length; i++) {
			Arrays.fill(dp[i], INF);
		}

		for (int diagonal = 0; diagonal < length; diagonal++) {
			for (int i = 0; i < length - diagonal; i++) {
				int j = i + diagonal;
				if (i == j) {
					dp[i][j] = 0;
					continue;
				}

				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j],
						dp[i][k] + dp[k + 1][j] + matrixSizes[i][0] * matrixSizes[k][1] * matrixSizes[j][1]);
				}
			}
		}

		return dp[0][length - 1];
	}
}

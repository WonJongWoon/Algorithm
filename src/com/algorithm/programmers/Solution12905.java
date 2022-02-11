package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/11
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12905

class Solution12905 {

	public int solution(int[][] board) {
		int height = board.length;
		int width = board[0].length;

		if (height < 2 || width < 2) {
			return 1;
		}

		int[][] dp = new int[height][width];

		for (int col = 0; col < width; col++) {
			dp[0][col] = board[0][col];
		}

		for (int row = 0; row < height; row++) {
			dp[row][0] = board[row][0];
		}

		int maxWidthOfRectangle = 0;
		for (int row = 1; row < height; row++) {
			for (int col = 1; col < width; col++) {
				if (board[row][col] == 0) {
					continue;
				}

				int minWidthOfRectangle = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]);
				dp[row][col] = minWidthOfRectangle + 1;
				maxWidthOfRectangle = Math.max(maxWidthOfRectangle, minWidthOfRectangle + 1);
			}
		}

		return maxWidthOfRectangle * maxWidthOfRectangle;
	}
}

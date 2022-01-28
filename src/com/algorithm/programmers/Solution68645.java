package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/28
// Problem : https://programmers.co.kr/learn/courses/30/lessons/68645

class Solution68645 {

	private final int[] dx = {0, 1, -1};
	private final int[] dy = {1, 0, -1};

	public int[] solution(int n) {
		int currentY = -1;
		int currentX = 0;
		int dir = 0;
		int num = 1;

		int[][] board = new int[n][n];
		for (int k = n; k > 0; k--) {
			for (int i = 0; i < k; i++) {
				currentY = currentY + dy[dir];
				currentX = currentX + dx[dir];
				board[currentY][currentX] = num++;
			}
			dir = (dir + 1) % 3;
		}

		int[] result = new int[(n * (n + 1)) >> 1];
		int idx = 0;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x <= y; x++) {
				result[idx++] = board[y][x];
			}
		}

		return result;
	}
}

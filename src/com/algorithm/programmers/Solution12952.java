package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/14
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12952

class Solution12952 {

	private static int answer = 0;

	public static void dfs(int[] map, int row) {
		if (row == map.length - 1) {
			answer++;
			return;
		}

		for (int col = 0; col < map.length; col++) {
			map[row + 1] = col;
			if (!placeable(map, row + 1)) {
				continue;
			}

			dfs(map, row + 1);
		}
	}

	private static boolean isInSameColumn(int[] map, int i, int j) {
		return map[i] == map[j];
	}

	private static boolean isInDiagonal(int[] map, int i, int j) {
		return (Math.abs(i - j) == Math.abs(map[i] - map[j]));
	}

	private static boolean placeable(int[] map, int row) {
		for (int i = 0; i < row; i++) {
			if (isInSameColumn(map, i, row) || isInDiagonal(map, i, row)) {
				return false;
			}
		}

		return true;
	}

	public int solution(int n) {
		for (int col = 0; col < n; col++) {
			int[] map = new int[n];
			map[0] = col;
			dfs(map, 0);
		}

		return answer;
	}
}

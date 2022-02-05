package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/05
// Problem : https://programmers.co.kr/learn/courses/30/lessons/77485

class Solution77485 {

	private int element(int rows, int x, int y) {
		return rows * x + y + 1;
	}

	public int rotate(int[][] matrix, int[] query) {
		int x1 = query[0] - 1;
		int y1 = query[1] - 1;
		int x2 = query[2] - 1;
		int y2 = query[3] - 1;

		int temporary = matrix[x1][y1];

		int min = temporary;
		for (int k = x1; k < x2; k++) {
			matrix[k][y1] = matrix[k + 1][y1];
			min = Math.min(matrix[k][y1], min);
		}

		for (int k = y1; k < y2; k++) {
			matrix[x2][k] = matrix[x2][k + 1];
			min = Math.min(matrix[x2][k], min);
		}

		for (int k = x2; k > x1; k--) {
			matrix[k][y2] = matrix[k - 1][y2];
			min = Math.min(matrix[k][y2], min);
		}

		for (int k = y2; k > y1; k--) {
			matrix[x1][k] = matrix[x1][k - 1];
			min = Math.min(matrix[x1][k], min);
		}

		matrix[x1][y1 + 1] = temporary;

		return min;
	}

	public int[] solution(int rows, int columns, int[][] queries) {
		int[][] matrix = new int[rows][columns];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				matrix[row][col] = element(columns, row, col);
			}
		}

		int[] result = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			result[i] = rotate(matrix, queries[i]);
		}

		return result;
	}
}

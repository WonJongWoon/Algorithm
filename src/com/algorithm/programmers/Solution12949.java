package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/08
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12949

class Solution12949 {

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int m = arr1.length, n = arr1[0].length, l = arr2[0].length;
		int[][] result = new int[m][l];

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < l; col++) {
				for (int k = 0; k < n; k++) {
					result[row][col] += arr1[row][k] * arr2[k][col];
				}
			}
		}

		return result;
	}
}

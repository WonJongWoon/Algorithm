package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/17
// Problem : https://programmers.co.kr/learn/courses/30/lessons/43105

import java.util.Arrays;

class Solution43105 {

	public int solution(int[][] triangle) {
		for (int row = 1; row < triangle.length; row++) {
			triangle[row][0] += triangle[row - 1][0];
			triangle[row][row] += triangle[row - 1][row - 1];

			for (int col = 1; col < row; col++) {
				triangle[row][col] += Math.max(triangle[row - 1][col - 1], triangle[row - 1][col]);
			}
		}

		return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
	}
}

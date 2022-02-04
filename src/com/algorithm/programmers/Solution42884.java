package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/04
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42884

import java.util.Arrays;
import java.util.Comparator;

class Solution42884 {

	public int solution(int[][] routes) {
		Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));

		int camera = Integer.MIN_VALUE;
		int result = 0;
		for (int[] route : routes) {
			if (camera < route[0]) {
				camera = route[1];
				result++;
			}
		}

		return result;
	}
}

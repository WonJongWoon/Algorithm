package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/07
// Problem : https://programmers.co.kr/learn/courses/30/lessons/43165

class Solution43165 {

	private int dfs(int[] numbers, int sum, int target, int depth) {
		if (depth == numbers.length) {
			return sum == target ? 1 : 0;
		}

		int v = numbers[depth];
		return dfs(numbers, sum + v, target, depth + 1) + dfs(numbers, sum - v, target, depth + 1);
	}

	public int solution(int[] numbers, int target) {
		return dfs(numbers, 0, target, 0);
	}
}

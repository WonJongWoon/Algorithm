package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/12
// Problem : https://programmers.co.kr/learn/courses/30/lessons/17687

class Solution17687 {

	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder(m * t);
		StringBuilder result = new StringBuilder();

		int number = 0;
		while (sb.length() < m * t) {
			sb.append(Integer.toString(number++, n));
		}

		for (int i = p - 1; i < m * t; i += m) {
			result.append(sb.charAt(i));
		}

		return result.toString().toUpperCase();
	}
}

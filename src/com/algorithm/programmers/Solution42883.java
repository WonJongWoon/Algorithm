package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/18
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42883

class Solution42883 {

	public String solution(String number, int k) {
		if (number.charAt(0) == '0') {
			return "0";
		}

		StringBuilder result = new StringBuilder();
		int idx = 0;
		char max;
		for (int i = 0; i < number.length() - k; i++) {
			max = 0;
			for (int j = idx; j <= k + i; j++) {
				if (max < number.charAt(j)) {
					max = number.charAt(j);
					idx = j + 1;
				}
			}

			result.append(max);
		}

		return result.toString();
	}
}

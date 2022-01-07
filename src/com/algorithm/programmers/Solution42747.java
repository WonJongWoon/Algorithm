package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/07
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42747

import java.util.Arrays;

class Solution42747 {
	public int solution(int[] citations) {
		Arrays.sort(citations);

		int result = 0;

		for (int i = 0; i < citations.length; i++) {
			if (citations.length - i <= citations[i]) {
				result = citations.length - i;
				break;
			}
		}

		return result;
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/10
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42862

import java.util.Arrays;

class Solution42862 {

	public int solution(int n, int[] lost, int[] reserve) {
		int[] students = new int[n];

		for (int i = 0; i < n; i++) {
			students[i]++;
		}

		for (int l : lost) {
			students[l - 1]--;
		}

		for (int r : reserve) {
			students[r - 1]++;
		}

		for (int i = 0; i < n; i++) {
			if (i - 1 >= 0 && students[i - 1] == 0 && students[i] >= 2) {
				students[i - 1]++;
				students[i]--;
			}
			if (i + 1 < n && students[i + 1] == 0 && students[i] >= 2) {
				students[i + 1]++;
				students[i]--;
			}
		}

		return (int)Arrays.stream(students).filter(student -> student >= 1).count();
	}
}

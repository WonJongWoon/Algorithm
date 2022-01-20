package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/20
// Problem : https://programmers.co.kr/learn/courses/30/lessons/43238

import java.util.Arrays;

class Solution43238 {

	private static boolean isPossibleTime(int[] times, int numOfPeople, long minTime) {
		long numOfPasser = 0;

		for (int time : times) {
			numOfPasser += (minTime / time);
		}

		return numOfPasser >= numOfPeople;
	}

	public long solution(int n, int[] times) {
		long l = 0;
		long r = (long)(1e18 + 1);

		Arrays.sort(times);

		while (l + 1 < r) {
			long m = (l + r) / 2;
			if (isPossibleTime(times, n, m)) {
				r = m;
			} else {
				l = m;
			}
		}

		return r;
	}
}

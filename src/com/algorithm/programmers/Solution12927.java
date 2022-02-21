package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/21
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12927

import java.util.Collections;
import java.util.PriorityQueue;

class Solution12927 {

	public long solution(int n, int[] works) {
		PriorityQueue<Integer> overtime = new PriorityQueue<>(Collections.reverseOrder());

		for (int work : works) {
			overtime.offer(work);
		}

		for (int idx = 0; idx < n; idx++) {
			int work = overtime.poll();
			if (work == 0) {
				break;
			}

			overtime.offer(work - 1);
		}

		long result = 0;
		for (long work : overtime) {
			result += (work * work);
		}

		return result;
	}
}

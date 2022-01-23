package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/08
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42586

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution42586 {

	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> works = new LinkedList<>();
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			works.offer((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
		}

		while (!works.isEmpty()) {
			int current = works.poll();
			int count = 1;

			while (!works.isEmpty() && works.peek() <= current) {
				count++;
				works.poll();
			}
			result.add(count);
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}

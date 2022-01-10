package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/10
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42889

import java.util.ArrayList;
import java.util.List;

class Solution42889 {

	private static class Stage implements Comparable<Stage> {

		private final int num;
		private final float failRate;

		public Stage(int num, float failRate) {
			this.num = num;
			this.failRate = failRate;
		}

		public int getNum() {
			return num;
		}

		public int compareTo(Stage other) {
			if (this.failRate == other.failRate) {
				return this.num - other.num;
			}

			return other.failRate - this.failRate >= 0 ? 1 : -1;
		}
	}

	public int[] solution(int N, int[] stages) {
		int[] people = new int[N + 2];
		int numOfPeople = stages.length;

		for (int stage : stages) {
			people[stage]++;
		}

		List<Stage> result = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			float rate = numOfPeople - people[i - 1] == 0 ? 0.0f : (float)people[i] / (numOfPeople - people[i - 1]);
			numOfPeople = Math.max(numOfPeople - people[i - 1], 0);
			result.add(new Stage(i, rate));
		}

		return result.stream().sorted().mapToInt(Stage::getNum).toArray();
	}
}

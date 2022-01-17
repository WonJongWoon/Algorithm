package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/17
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42861

import java.util.Arrays;
import java.util.Comparator;

class Solution42861 {

	private static class Dsu {

		private final int[] parent;

		public Dsu(int size) {
			this.parent = new int[size];
			for (int i = 0; i < size; i++) {
				parent[i] = i;
			}
		}

		public int find(int x) {
			if (parent[x] == x) {
				return x;
			}

			parent[x] = find(parent[x]);
			return parent[x];
		}

		public boolean union(int x, int y) {
			int parentX = find(x);
			int parentY = find(y);

			if (parentX == parentY) {
				return false;
			}

			parent[parentY] = parentX;
			return true;
		}
	}

	public int solution(int n, int[][] costs) {
		Arrays.sort(costs, Comparator.comparingInt(cost -> cost[2]));

		Dsu d = new Dsu(n);
		int result = 0;
		int count = 0;

		for (int[] cost : costs) {
			if (count == n - 1) {
				break;
			}

			if (d.union(cost[0], cost[1])) {
				result += cost[2];
				count++;
			}
		}

		return result;
	}
}

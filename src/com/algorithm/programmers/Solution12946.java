package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/22
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12946

import java.util.ArrayList;
import java.util.List;

class Solution12946 {

	private static class Move {

		private final int from;
		private final int to;

		public Move(int from, int to) {
			this.from = from;
			this.to = to;
		}

		public int from() {
			return from;
		}

		public int to() {
			return to;
		}
	}

	private final List<Move> moves = new ArrayList<>();

	public int[][] solution(int n) {
		hanoi(n, 1, 3, 2);

		int[][] result = new int[moves.size()][2];
		for (int idx = 0; idx < result.length; idx++) {
			Move move = moves.get(idx);
			result[idx][0] = move.from();
			result[idx][1] = move.to();
		}

		return result;
	}

	private void hanoi(int n, int from, int to, int stopover) {
		if (n == 1) {
			moves.add(new Move(from, to));
		} else {
			hanoi(n - 1, from, stopover, to);
			moves.add(new Move(from, to));
			hanoi(n - 1, stopover, to, from);
		}
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/18
// Problem : https://programmers.co.kr/learn/courses/30/lessons/1844

import java.util.LinkedList;
import java.util.Queue;

class Solution1844 {

	private final static int[] dx = {1, -1, 0, 0};
	private final static int[] dy = {0, 0, -1, 1};
	private final static int WALL = 0;

	private static class Pair {

		private final int x;
		private final int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;

		Queue<Pair> q = new LinkedList<>();
		int[][] distance = new int[n][m];

		q.offer(new Pair(0, 0));
		distance[0][0] = 1;

		while (!q.isEmpty()) {
			Pair current = q.poll();
			int currentX = current.getX();
			int currentY = current.getY();

			for (int dir = 0; dir < 4; dir++) {
				int nextX = currentX + dx[dir];
				int nextY = currentY + dy[dir];

				if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
					continue;
				}

				if (maps[nextY][nextX] == WALL || distance[nextY][nextX] != 0) {
					continue;
				}

				distance[nextY][nextX] = distance[currentY][currentX] + 1;
				q.offer(new Pair(nextX, nextY));
			}
		}

		return distance[n - 1][m - 1] == 0 ? -1 : distance[n - 1][m - 1];
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/15
// Problem : https://programmers.co.kr/learn/courses/30/lessons/81302

import java.util.LinkedList;
import java.util.Queue;

class Solution81302 {

	private static final int SIZE = 5;

	private static final char PARTITION = 'X';
	private static final char PERSON = 'P';

	private static final int[] dr = {-1, 1, 0, 0};
	private static final int[] dc = {0, 0, -1, 1};

	private static class Position {

		private final int row;
		private final int col;

		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public int row() {
			return row;
		}

		public int col() {
			return col;
		}
	}

	public static char[][] toRoom(String[] place) {
		char[][] result = new char[SIZE][SIZE];

		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				result[row][col] = place[row].charAt(col);
			}
		}

		return result;
	}

	public static int solve(String[] place) {
		char[][] room = toRoom(place);
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if (room[row][col] != PERSON) {
					continue;
				}

				if (!bfs(room, row, col)) {
					return 0;
				}
			}
		}

		return 1;
	}

	private static boolean isOutOfRange(int row, int col) {
		return (row < 0 || col < 0 || row >= SIZE || col >= SIZE);
	}

	private static boolean bfs(char[][] room, int row, int col) {
		boolean[][] visited = new boolean[SIZE][SIZE];
		Queue<Position> q = new LinkedList<>();

		q.offer(new Position(row, col));
		visited[row][col] = true;

		while (!q.isEmpty()) {
			Position position = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nextRow = position.row() + dr[dir];
				int nextCol = position.col() + dc[dir];

				if (isOutOfRange(nextRow, nextCol)) {
					continue;
				}

				if (visited[nextRow][nextCol]) {
					continue;
				}

				int distance = Math.abs(nextRow - row) + Math.abs(nextCol - col);
				if (distance > 2) {
					continue;
				}

				visited[nextRow][nextCol] = true;

				if (room[nextRow][nextCol] == PARTITION) {
					continue;
				}

				if (room[nextRow][nextCol] == PERSON) {
					return false;
				}

				q.offer(new Position(nextRow, nextCol));
			}
		}

		return true;
	}

	public int[] solution(String[][] places) {
		int[] result = new int[places.length];
		for (int i = 0; i < places.length; i++) {
			result[i] = solve(places[i]);
		}

		return result;
	}
}

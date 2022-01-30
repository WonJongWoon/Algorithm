package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/30
// Problem : https://programmers.co.kr/learn/courses/30/lessons/49994

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution49994 {

	private static final int HALF_LENGTH = 5;

	private static class Position {

		private final int x;
		private final int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;

			if (!(o instanceof Position))
				return false;

			Position position = (Position)o;
			return x == position.x && y == position.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	private static class GameCharacter {

		private Position position;
		private final int width;
		private final int height;

		public GameCharacter(int width, int height, int x, int y) {
			this.width = width;
			this.height = height;
			this.position = new Position(x, y);
		}

		public Position getPosition() {
			return new Position(position.x, position.y);
		}

		private int boundary(int base, int delta, int lowerBound, int upperBound) {
			if (delta >= 0) {
				return Math.min(base + delta, upperBound);
			} else {
				return Math.max(base + delta, lowerBound);
			}
		}

		private Position move(int x, int y) {
			int nextX = boundary(position.x, x, -1 * width, width);
			int nextY = boundary(position.y, y, -1 * height, height);
			position = new Position(nextX, nextY);
			return position;
		}

		public Position move(char direction) {
			switch (direction) {
				case 'U':
					return move(0, 1);
				case 'D':
					return move(0, -1);
				case 'L':
					return move(-1, 0);
				case 'R':
					return move(1, 0);
				default:
					return move(0, 0);
			}
		}
	}

	public static class Road {

		private final Position first;
		private final Position second;

		public Road(Position first, Position second) {
			if (first.getX() == second.getX()) {
				this.first = first.getY() <= second.getY() ? first : second;
				this.second = first.getY() <= second.getY() ? second : first;
			} else {
				this.first = first.getX() < second.getX() ? first : second;
				this.second = first.getX() < second.getX() ? second : first;
			}
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;

			if (!(o instanceof Road))
				return false;

			Road road = (Road)o;
			return this.first.equals(road.first) && this.second.equals(road.second);
		}

		@Override
		public int hashCode() {
			return Objects.hash(first, second);
		}
	}

	public int solution(String dirs) {
		GameCharacter character = new GameCharacter(HALF_LENGTH, HALF_LENGTH, 0, 0);
		Set<Road> navigation = new HashSet<>();

		for (char dir : dirs.toCharArray()) {
			Position current = character.getPosition();
			Position next = character.move(dir);

			if (!(current.equals(next))) {
				navigation.add(new Road(current, next));
			}
		}

		return navigation.size();
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/07
// Problem : https://programmers.co.kr/learn/courses/30/lessons/17686

import java.util.Arrays;

class Solution17686 {

	private static boolean isLetter(char c) {
		return !isDigit(c);
	}

	private static boolean isDigit(char c) {
		return Character.isDigit(c);
	}

	private static class Tuple {

		private final int first;
		private final int second;

		public Tuple(int first, int second) {
			this.first = first;
			this.second = second;
		}

		public int first() {
			return first;
		}

		public int second() {
			return second;
		}
	}

	private static class File implements Comparable<File> {
		
		private final String fileName;
		private final String head;
		private final int number;
		private final String tail;

		private Tuple parse(String fileName) {
			char[] chars = fileName.toCharArray();

			int start = -1;
			int end = -1;

			for (int i = 1; i < chars.length; i++) {
				if (isLetter(chars[i - 1]) && isDigit(chars[i])) {
					start = i;
				} else if (isDigit(chars[i - 1]) && isLetter(chars[i])) {
					end = i;
					break;
				}
			}

			return new Tuple(start, end == -1 ? fileName.length() : end);
		}

		public File(String fileName) {
			Tuple result = parse(fileName);
			this.head = fileName.substring(0, result.first());
			this.number = Integer.parseInt(fileName.substring(result.first(), result.second()));
			this.tail = fileName.substring(result.second());
			this.fileName = fileName;
		}

		public int compareTo(File other) {
			if (this.head.equalsIgnoreCase(other.head)) {
				return this.number - other.number;
			}

			return this.head.toLowerCase().compareTo(other.head.toLowerCase());
		}

		@Override
		public String toString() {
			return fileName;
		}
	}

	public String[] solution(String[] files) {
		return Arrays.stream(files)
			.map(File::new)
			.sorted()
			.map(File::toString)
			.toArray(String[]::new);
	}
}

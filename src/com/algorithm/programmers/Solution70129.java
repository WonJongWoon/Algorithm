package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/18
// Problem : https://programmers.co.kr/learn/courses/30/lessons/70129

class Solution70129 {

	private static class Translation {

		private final int numOfEraseZero;
		private final char[] result;

		public Translation(int numOfEraseZero, char[] result) {
			this.numOfEraseZero = numOfEraseZero;
			this.result = result;
		}

		public static Translation make(char[] chars) {
			int numOfZero = 0;

			for (char v : chars) {
				numOfZero += (v == '0' ? 1 : 0);
			}

			return new Translation(numOfZero, toBinaryString(chars.length - numOfZero));
		}

		public int getNumOfEraseZero() {
			return numOfEraseZero;
		}

		public char[] getResult() {
			return result;
		}

		public boolean isFinish() {
			return (result.length == 1) && (result[0] == '1');
		}
	}

	private static char[] toBinaryString(int number) {
		final char[] symbols = {'0', '1'};

		int len = (int)(Math.log10(number) / Math.log10(2)) + 1;
		char[] result = new char[len];

		for (int i = 0; i < len; i++) {
			result[len - i - 1] = symbols[number % 2];
			number /= 2;
		}

		return result;
	}

	public int[] solution(String s) {
		int result = 0;
		int count = 0;

		Translation t = Translation.make(s.toCharArray());
		result += t.getNumOfEraseZero();
		count++;

		while (!t.isFinish()) {
			t = Translation.make(t.getResult());
			result += t.getNumOfEraseZero();
			count++;
		}

		return new int[] {count, result};
	}
}

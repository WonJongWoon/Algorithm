package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/29
// Problem : https://programmers.co.kr/learn/courses/30/lessons/17677

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class Solution17677 {

	private static class JaccardSet {

		private final Map<String, Integer> set;
		private static final int FACTOR = 65536;

		public JaccardSet(String str) {
			this.set = generateSet(str);
		}

		private Map<String, Integer> generateSet(String str) {
			Map<String, Integer> tokens = new HashMap<>();

			for (int idx = 0; idx < (str.length() - 1); idx++) {
				if (!Character.isLetter(str.charAt(idx)) || !Character.isLetter(str.charAt(idx + 1))) {
					continue;
				}

				String key = str.substring(idx, idx + 2).toLowerCase();
				tokens.put(key, tokens.getOrDefault(key, 0) + 1);
			}

			return tokens;
		}

		private int numOfDifference(JaccardSet other) {
			int result = 0;

			for (Map.Entry<String, Integer> entry : set.entrySet()) {
				if (!other.set.containsKey(entry.getKey())) {
					result += entry.getValue();
				}
			}

			return result;
		}

		private int numOfIntersection(JaccardSet other, BiFunction<Integer, Integer, Integer> cmp) {
			int result = 0;

			for (Map.Entry<String, Integer> entry : set.entrySet()) {
				if (other.set.containsKey(entry.getKey())) {
					result += cmp.apply(entry.getValue(), other.set.get(entry.getKey()));
				}
			}

			return result;
		}

		private int calculateSimilarity(int common, int total) {
			if (common == 0 && total == 0) {
				return FACTOR;
			}

			double similarity = (double)common / total;
			return (int)Math.floor(similarity * FACTOR);
		}

		public int similarity(JaccardSet other) {
			int minOfCommon = this.numOfIntersection(other, Math::min);
			int maxOfCommon = this.numOfIntersection(other, Math::max);
			int total = this.numOfDifference(other) + other.numOfDifference(this) + maxOfCommon;

			return calculateSimilarity(minOfCommon, total);
		}
	}

	public int solution(String str1, String str2) {
		return new JaccardSet(str1).similarity(new JaccardSet(str2));
	}
}

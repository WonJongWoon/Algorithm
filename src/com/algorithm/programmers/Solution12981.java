package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/10
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12981

import java.util.HashSet;
import java.util.Set;

class Solution12981 {

	public int[] solution(int n, String[] words) {
		Set<String> s = new HashSet<>();

		char prevLastChar = words[0].charAt(words[0].length() - 1);
		s.add(words[0]);

		for (int i = 1; i < words.length; i++) {
			String word = words[i];
			char firstChar = word.charAt(0);

			if (prevLastChar == firstChar && !s.contains(word)) {
				prevLastChar = word.charAt(word.length() - 1);
				s.add(word);
			} else {
				return new int[] {(i % n) + 1, (i / n) + 1};
			}
		}

		return new int[] {0, 0};
	}
}

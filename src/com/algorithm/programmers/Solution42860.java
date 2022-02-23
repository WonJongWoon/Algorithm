package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/23
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42860

class Solution42860 {

	public int solution(String name) {
		int offset = name.length() - 1;

		int result = 0;
		for (int idx = 0; idx < name.length(); idx++) {
			if (name.charAt(idx) > 'N') {
				result += ('Z' - name.charAt(idx) + 1);
			} else {
				result += (name.charAt(idx) - 'A');
			}

			int next = idx + 1;
			while ((next < name.length()) && (name.charAt(next) == 'A')) {
				next++;
			}

			offset = Math.min(offset, (2 * idx) + name.length() - next);
		}

		result += offset;

		return result;
	}
}

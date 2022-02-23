package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/23
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42860

class Solution42860 {

	public int solution(String name) {
		int length = name.length();
		int offset = length - 1;

		int result = 0;
		for (int idx = 0; idx < length; idx++) {
			result += Math.min(name.charAt(idx) - 'A', 'Z' - name.charAt(idx) + 1);

			int next = idx + 1;
			while ((next < length) && (name.charAt(next) == 'A')) {
				next++;
			}

			offset = Math.min(offset, idx + length - next + Math.min(idx, length - next));
		}

		result += offset;

		return result;
	}
}

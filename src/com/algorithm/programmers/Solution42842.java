package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/07
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42842

class Solution42842 {
	public int[] solution(int brown, int yellow) {
		int d = (int)Math.sqrt(Math.pow((brown + 4) / 2, 2) - 4 * (brown + yellow));
		return new int[] {(brown + 4 + 2 * d) / 4, (brown + 4 - 2 * d) / 4};
	}
}

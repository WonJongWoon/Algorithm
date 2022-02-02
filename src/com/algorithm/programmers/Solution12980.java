package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/02
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12980

class Solution12980 {

	public int solution(int n) {
		int result = 0;
		while (n != 0) {
			if ((n & 1) == 0) {
				n >>= 1;
			} else {
				n--;
				result++;
			}
		}

		return result;
	}
}

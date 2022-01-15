package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/15
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12953

import java.math.BigInteger;

class Solution12953 {

	private int gcd(int a, int b) {
		return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
	}

	private int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}

	public int solution(int[] arr) {

		int lcm = arr[0];
		for (int i = 1; i < arr.length; i++) {
			lcm = lcm(lcm, arr[i]);
		}

		return lcm;
	}
}

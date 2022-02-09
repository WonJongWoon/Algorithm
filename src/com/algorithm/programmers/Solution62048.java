package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/09
// Problem : https://programmers.co.kr/learn/courses/30/lessons/62048

import java.math.BigInteger;

class Solution62048 {

	public long solution(int w, int h) {
		long totalCount = (long)w * (long)h;
		long eraseCount = (long)w + (long)h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
		return totalCount - eraseCount;
	}
}

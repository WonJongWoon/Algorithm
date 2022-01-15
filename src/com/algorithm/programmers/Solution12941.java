package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/15
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12941

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution12941 {
	
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		return IntStream.range(0, A.length).map(i -> A[i] * B[A.length - i - 1]).sum();
	}
}

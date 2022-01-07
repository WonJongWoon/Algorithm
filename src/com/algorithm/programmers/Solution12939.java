package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/07
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12939

import java.util.Arrays;
import java.util.stream.Stream;

class Solution12939 {
	
	public String solution(String s) {
		int[] arr = Stream.of(s.split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		Arrays.sort(arr);
		return String.format("%d %d", arr[0], arr[arr.length - 1]);
	}
}

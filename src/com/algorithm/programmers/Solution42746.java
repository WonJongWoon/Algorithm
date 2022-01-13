package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/13
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42746

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution42746 {

	private int concat2Int(int v1, int v2) {
		int len = v2 == 0 ? 1 : (int)Math.log10(v2) + 1;
		return v1 * (int)Math.pow(10, len) + v2;
	}

	public String solution(int[] numbers) {

		List<Integer> arr = Arrays.stream(numbers).boxed().collect(Collectors.toList());
		Collections.sort(arr, (v1, v2) -> concat2Int(v2, v1) - concat2Int(v1, v2));

		String result = arr.stream().map(String::valueOf).collect(Collectors.joining());
		return result.charAt(0) == '0' ? "0" : result;
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/23
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42578

import java.util.HashMap;
import java.util.Map;

class Solution42578 {

	public int solution(String[][] clothes) {
		Map<String, Integer> table = new HashMap<>();

		for (String[] clothe : clothes) {
			table.put(clothe[1], table.getOrDefault(clothe[1], 0) + 1);
		}

		int result = 1;
		for (String key : table.keySet()) {
			result *= (table.get(key) + 1);
		}

		return result - 1;
	}
}

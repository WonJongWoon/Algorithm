package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/19
// Problem : https://programmers.co.kr/learn/courses/30/lessons/17684

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution17684 {

	private static Map<String, Integer> defaultDictionary() {
		Map<String, Integer> dictionary = new HashMap<>();
		for (char c = 'A'; c <= 'Z'; c++) {
			dictionary.put(String.valueOf(c), c - 'A' + 1);
		}

		return dictionary;
	}

	public int[] solution(String msg) {
		Map<String, Integer> dictionary = defaultDictionary();

		List<Integer> result = new ArrayList<>();
		for (int start = 0; start < msg.length(); ) {
			int end = start + 1;
			while (end <= msg.length()) {
				String newWord = msg.substring(start, end);
				if (!dictionary.containsKey(newWord)) {
					break;
				}

				end++;
			}

			String existsLongWord = msg.substring(start, end - 1);
			result.add(dictionary.get(existsLongWord));

			String notExistLongWord = msg.substring(start, Math.min(msg.length(), end));
			dictionary.put(notExistLongWord, dictionary.size() + 1);

			start += existsLongWord.length();
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}

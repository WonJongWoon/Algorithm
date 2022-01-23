package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/16
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42577

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution42577 {

	public boolean solution(String[] phoneBook) {
		Set<String> table = Arrays.stream(phoneBook).collect(Collectors.toSet());

		for (String phone : table) {
			for (int i = 1; i < phone.length(); i++) {
				if (table.contains(phone.substring(0, i))) {
					return false;
				}
			}
		}

		return true;
	}
}

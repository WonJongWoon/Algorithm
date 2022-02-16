package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/16
// Problem : https://programmers.co.kr/learn/courses/30/lessons/64065

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution64065 {

	public int[] solution(String s) {
		String[] elements = s.replaceAll("[{}]", " ").trim().split(" ,");
		Arrays.sort(elements, Comparator.comparingInt(String::length));

		Set<Integer> set = new HashSet<>();
		int[] result = new int[elements.length];
		for (int idx = 0; idx < elements.length; idx++) {
			String element = elements[idx];
			for (String e : element.split(",")) {
				int number = Integer.parseInt(e.trim());
				if (set.contains(number)) {
					continue;
				}

				set.add(number);
				result[idx] = number;
			}
		}

		return result;
	}
}

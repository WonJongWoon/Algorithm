package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/24
// Problem : https://programmers.co.kr/learn/courses/30/lessons/17680

import java.util.Deque;
import java.util.LinkedList;

class Solution17680 {

	public int solution(int cacheSize, String[] cities) {
		Deque<String> cache = new LinkedList<>();

		if (cacheSize == 0) {
			return cities.length * 5;
		}

		for (int i = 0; i < cities.length; i++) {
			cities[i] = cities[i].toUpperCase();
		}

		int result = 0;
		for (String city : cities) {
			if (cache.contains(city)) {
				cache.remove(city);
				cache.addLast(city);
				result += 1;
			} else {
				if (cache.size() == cacheSize) {
					cache.removeFirst();
				}
				cache.addLast(city);
				result += 5;
			}
		}

		return result;
	}
}

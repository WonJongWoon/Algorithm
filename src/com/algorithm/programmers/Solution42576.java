package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/05
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42576

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution42576 {

	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> infos = new HashMap<>();

		for (String player : participant) {
			infos.put(player, infos.getOrDefault(player, 0) + 1);
		}

		for (String player : completion) {
			infos.put(player, infos.get(player) - 1);
		}

		return infos.entrySet().stream().filter(info -> info.getValue() != 0).map(Entry::getKey).findFirst().orElse("");
	}
}

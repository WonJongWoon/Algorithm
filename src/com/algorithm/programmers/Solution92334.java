package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/19
// Problem : https://programmers.co.kr/learn/courses/30/lessons/92334

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class Solution92334 {

	private static Map<String, Set<String>> summaryReport(String[] reports) {
		Map<String, Set<String>> table = new HashMap<>();
		for (String report : reports) {
			String[] tokens = report.split(" ");
			String from = tokens[0];
			String to = tokens[1];

			table.computeIfAbsent(to, (it) -> new HashSet<>()).add(from);
		}

		return table;
	}

	private static Map<String, Integer> counterReport(String[] ids) {
		Map<String, Integer> counter = new LinkedHashMap<>();
		for (String id : ids) {
			counter.put(id, 0);
		}

		return counter;
	}

	public int[] solution(String[] ids, String[] reports, int k) {

		Map<String, Set<String>> summaryReport = summaryReport(reports);
		Map<String, Integer> counterReport = counterReport(ids);

		for (Map.Entry<String, Set<String>> entry : summaryReport.entrySet()) {
			if (entry.getValue().size() < k) {
				continue;
			}

			for (String from : entry.getValue()) {
				counterReport.put(from, counterReport.getOrDefault(from, 0) + 1);
			}
		}

		return counterReport.values().stream().mapToInt(Integer::intValue).toArray();
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/19
// Problem : https://programmers.co.kr/learn/courses/30/lessons/43164

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution43164 {

	private boolean[] visited;
	private List<List<String>> paths;

	public String[] solution(String[][] tickets) {
		int depth = 0;
		visited = new boolean[tickets.length];
		paths = new ArrayList<>();

		Arrays.sort(tickets, (t1, t2) -> {
			if (t1[0].equals(t2[0])) {
				return t1[1].compareTo(t2[1]);
			}

			return t1[0].compareTo(t2[0]);
		});

		dfs(tickets, "ICN", new ArrayList<>(Collections.singletonList("ICN")), depth);
		paths.sort(Comparator.comparingInt(List::size));

		return paths.get(0).toArray(new String[0]);
	}

	public void dfs(String[][] tickets, String start, List<String> path, int depth) {
		if (depth == tickets.length) {
			paths.add(path);
			return;
		}

		for (int idx = 0; idx < tickets.length; idx++) {
			String source = tickets[idx][0];
			String destination = tickets[idx][1];

			if (visited[idx] || !start.equals(source)) {
				continue;
			}

			visited[idx] = true;
			List<String> newPath = new ArrayList<>(path);
			newPath.add(destination);
			dfs(tickets, destination, newPath, depth + 1);
			visited[idx] = false;
		}
	}
}

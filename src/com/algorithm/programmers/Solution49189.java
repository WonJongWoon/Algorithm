package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/16
// Problem : https://programmers.co.kr/learn/courses/30/lessons/49189

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution49189 {

	public List<List<Integer>> makeGraph(int n, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			int from = edge[0] - 1;
			int to = edge[1] - 1;
			graph.get(from).add(to);
			graph.get(to).add(from);
		}

		return graph;
	}

	public int solution(int n, int[][] edges) {
		final int INF = 987654321;
		final int start = 0;

		List<List<Integer>> graph = makeGraph(n, edges);
		int[] distance = new int[n];

		Arrays.fill(distance, INF);

		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		distance[start] = 0;

		while (!q.isEmpty()) {
			int current = q.poll();

			for (int next : graph.get(current)) {
				if (distance[next] != INF) {
					continue;
				}

				distance[next] = distance[current] + 1;
				q.offer(next);
			}
		}

		int max = Arrays.stream(distance).max().getAsInt();
		return (int)Arrays.stream(distance).filter(v -> v == max).count();
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/31
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42579

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution42579 {

	private static class Genre implements Comparable<Genre> {

		private final int id;
		private final int play;

		public Genre(int id, int play) {
			this.id = id;
			this.play = play;
		}

		public int getId() {
			return id;
		}

		@Override
		public int compareTo(Genre other) {
			return other.play - this.play;
		}
	}

	public int[] solution(String[] genres, int[] plays) {
		final Map<String, Integer> freq = new HashMap<>();
		for (int id = 0; id < genres.length; id++) {
			freq.put(genres[id], freq.getOrDefault(genres[id], 0) + plays[id]);
		}

		Map<String, PriorityQueue<Genre>> statistics = new TreeMap<>((s1, s2) -> freq.get(s2) - freq.get(s1));
		for (int id = 0; id < genres.length; id++) {
			statistics.computeIfAbsent(genres[id], (key) -> new PriorityQueue<>()).add(new Genre(id, plays[id]));
		}

		List<Integer> result = new ArrayList<>();
		for (PriorityQueue<Genre> songs : statistics.values()) {
			int length = Math.min(songs.size(), 2);
			for (int idx = 0; idx < length; idx++) {
				result.add(songs.poll().getId());
			}
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}

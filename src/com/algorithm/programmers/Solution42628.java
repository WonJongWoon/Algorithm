package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/20
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42628

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution42628 {

	public int[] solution(String[] operations) {

		PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();

		for (String operation : operations) {
			String[] tokens = operation.split(" ");
			String command = tokens[0];

			if ("I".equals(command)) {
				int arg = Integer.parseInt(tokens[1]);
				maxPriorityQueue.offer(arg);
				minPriorityQueue.offer(arg);
			} else if ("D".equals(command) && !maxPriorityQueue.isEmpty()) {
				String arg = tokens[1];
				if ("1".equals(arg)) {
					minPriorityQueue.remove(maxPriorityQueue.poll());
				} else {
					maxPriorityQueue.remove(minPriorityQueue.poll());
				}
			}
		}

		int[] result = new int[2];
		if (!minPriorityQueue.isEmpty()) {
			result[0] = maxPriorityQueue.peek();
			result[1] = minPriorityQueue.peek();
		}

		return result;
	}
}

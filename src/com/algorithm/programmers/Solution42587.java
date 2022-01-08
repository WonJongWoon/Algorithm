package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/08
// Problem : https://programmers.co.kr/learn/courses/30/gitlessons/42587

import java.util.LinkedList;
import java.util.Queue;

class Solution42587 {

	private static class Print {

		private final int order;
		private final int priority;

		public Print(int priority, int order) {
			this.order = order;
			this.priority = priority;
		}

		public int order() {
			return order;
		}

		public int priority() {
			return priority;
		}
	}

	public int solution(int[] priorities, int location) {
		Queue<Print> queue = new LinkedList<>();
		int[] orders = new int[priorities.length];

		for (int i = 0; i < priorities.length; i++) {
			queue.offer(new Print(priorities[i], i));
		}

		int count = 1;

		while (!queue.isEmpty()) {
			Print j = queue.poll();
			boolean isExist = false;

			for (int i = 0; i < queue.size(); i++) {
				Print p = queue.poll();

				if (p.priority() > j.priority()) {
					isExist = true;
				}

				queue.offer(p);
			}

			if (isExist) {
				queue.offer(j);
			} else {
				orders[j.order()] = count++;
			}
		}

		return orders[location];
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/13
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42627

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution42627 {

	private static class Job implements Comparable<Job> {

		private final int requestTime;
		private final int workingTime;

		public Job(int requestTime, int workingTime) {
			this.requestTime = requestTime;
			this.workingTime = workingTime;
		}

		public int compareTo(Job other) {
			return workingTime - other.workingTime;
		}

		public int requestTime() {
			return requestTime;
		}

		public int workingTime() {
			return workingTime;
		}
	}

	public int solution(int[][] jobs) {
		PriorityQueue<Job> pq = new PriorityQueue<>();
		Arrays.sort(jobs, Comparator.comparingInt(j -> j[0]));

		int total = 0;
		int current = 0;
		int idx = 0;
		while (idx < jobs.length || !pq.isEmpty()) {
			while (idx < jobs.length && jobs[idx][0] <= current) {
				pq.offer(new Job(jobs[idx][0], jobs[idx][1]));
				idx++;
			}

			if (pq.isEmpty()) {
				current = jobs[idx][0];
			} else {
				Job job = pq.poll();
				total += (current + job.workingTime() - job.requestTime());
				current += job.workingTime();
			}
		}

		return (total / jobs.length);

	}
}

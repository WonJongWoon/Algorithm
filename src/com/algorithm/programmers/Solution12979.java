package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/07
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12979

class Solution12979 {

	private int calculateSize(int size, int w) {
		int totalArea = 2 * w + 1;
		return (size / totalArea) + (((size % totalArea) == 0) ? 0 : 1);
	}

	private int minimumStations(int numOfApartments, int[] stations, int w) {
		int start = Math.max(1, stations[0] - w);
		int prevRight = Math.min(stations[0] + w, numOfApartments);

		int installStations = 0;
		for (int idx = 1; idx < stations.length; idx++) {
			int left = Math.max(1, stations[idx] - w);
			int right = Math.min(stations[idx] + w, numOfApartments);

			if (left > prevRight) {
				installStations += calculateSize(left - prevRight - 1, w);
			}

			prevRight = right;
		}

		if (start != 1) {
			installStations += calculateSize(start - 1, w);
		}

		if (prevRight != numOfApartments) {
			installStations += calculateSize(numOfApartments - prevRight, w);
		}

		return installStations;
	}

	public int solution(int n, int[] stations, int w) {
		return minimumStations(n, stations, w);
	}
}

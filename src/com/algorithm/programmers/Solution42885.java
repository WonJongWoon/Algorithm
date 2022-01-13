package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/13
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42885

import java.util.Arrays;

class Solution42885 {
	public int solution(int[] people, int limit) {
		int result = 0;

		Arrays.sort(people);
		int left = 0, right = people.length - 1;

		while (left < right) {
			if (people[left] + people[right] <= limit) {
				left++;
				right--;
			} else {
				right--;
			}
			result++;
		}

		return left == right ? result + 1 : result;
	}
}

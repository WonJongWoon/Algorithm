package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/22
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12951

class Solution12951 {

	public String solution(String s) {
		char[] chars = s.toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);

		for (int i = 1; i < chars.length; i++) {
			if (chars[i - 1] == ' ') {
				chars[i] = Character.toUpperCase(chars[i]);
			} else {
				chars[i] = Character.toLowerCase(chars[i]);
			}
		}

		return String.valueOf(chars);
	}
}

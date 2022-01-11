package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/11
// Problem : https://programmers.co.kr/learn/courses/30/lessons/17682

class Solution17682 {

	private int bonus(char value) {
		switch (value) {
			case 'S':
				return 1;
			case 'D':
				return 2;
			case 'T':
				return 3;
			default:
				return -1;
		}
	}

	private boolean matchBonus(char value) {
		return (value == 'S' || value == 'D' || value == 'T');
	}

	private boolean existsOption(char value) {
		return (value == '#' || value == '*');
	}

	private int option(char value) {
		return value == '#' ? -1 : 2;
	}

	public int solution(String dartResult) {
		char[] chars = dartResult.toCharArray();
		int result = 0, start = 0, end = 0;
		int prevScore = 0;

		while (start < chars.length - 1) {
			if (!matchBonus(chars[end])) {
				end++;
				continue;
			}

			int score = Integer.parseInt(dartResult.substring(start, end));
			int stageScore = (int)Math.pow(score, bonus(chars[end]));

			if (end + 1 >= chars.length) {
				result += stageScore;
				break;
			}

			if (existsOption(chars[end + 1])) {
				int option = option(chars[end + 1]);
				stageScore = stageScore * option;
				result += ((option < 0 ? 0 : prevScore) + stageScore);
				end = start = end + 2;
			} else {
				result += stageScore;
				end = start = end + 1;
			}

			prevScore = stageScore;
		}

		return result;
	}
}

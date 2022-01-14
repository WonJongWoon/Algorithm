package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/14
// Problem : https://programmers.co.kr/learn/courses/30/lessons/60058

class Solution60058 {

	private boolean valid(String p) {
		int count = 0;

		for (char v : p.toCharArray()) {
			count += (v == '(' ? 1 : -1);

			if (count < 0) {
				return false;
			}
		}

		return true;
	}

	private int balancedPos(String p) {
		char[] chars = p.toCharArray();
		int count = 0;

		for (int i = 0; i < chars.length; i++) {
			count += (chars[i] == '(' ? 1 : -1);

			if (count == 0) {
				return i + 1;
			}
		}

		return -1;
	}

	private String inverse(String p) {
		char[] chars = p.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			chars[i] = chars[i] == ')' ? '(' : ')';
		}

		return String.valueOf(chars);
	}

	private String make(String p) {
		if ("".equals(p)) {
			return "";
		}

		int balancedPos = balancedPos(p);
		String u = p.substring(0, balancedPos);
		String v = p.substring(balancedPos);

		if (valid(u)) {
			return u + make(v);
		} else {
			return "(" + make(v) + ")" + inverse(u.substring(1, u.length() - 1));
		}
	}

	public String solution(String p) {
		return make(p);
	}
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12926


class Solution12926 {

    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        final int SPACE = ' ';

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != SPACE) {
                int start = Character.isUpperCase(chars[i]) ? 'A' : 'a';
                int end = Character.isUpperCase(chars[i]) ? 'Z' : 'z';
                int idx = chars[i] - start;
                chars[i] = (char) ((idx + n) % (end - start + 1) + start);
            }
        }

        return String.valueOf(chars);
    }
}

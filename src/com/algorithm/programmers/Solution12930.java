package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/05
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12930

class Solution12930 {

    public String solution(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0, start = 0; i < chars.length; i++) {
            if (' ' == chars[i]) {
                start = 0;
                continue;
            }

            chars[i] = (start++ % 2 == 0) ? Character.toUpperCase(chars[i])
                : Character.toLowerCase(chars[i]);
        }

        return String.valueOf(chars);
    }
}

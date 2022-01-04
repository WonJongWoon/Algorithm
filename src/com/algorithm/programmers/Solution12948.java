package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/04
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12948

class Solution12948 {

    public String solution(String phoneNumber) {
        char[] chars = phoneNumber.toCharArray();

        for (int i = 0; i < phoneNumber.length() - 4; i++) {
            chars[i] = '*';
        }

        return String.valueOf(chars);
    }
}

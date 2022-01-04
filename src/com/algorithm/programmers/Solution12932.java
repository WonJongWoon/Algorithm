package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/04
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12932

class Solution12932 {

    public int[] solution(long n) {
        int len = (int) Math.log10(n) + 1;
        int[] result = new int[len];

        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (n % 10);
            n /= 10;
        }

        return result;
    }
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/77884

class Solution77884 {

    private static boolean hasEvenDisivors(int value) {
        return !isPow(value);
    }

    private static boolean isPow(int value) {
        double sqrt = Math.sqrt(value);
        return Math.floor(sqrt) == sqrt;
    }

    public int solution(int left, int right) {
        int result = 0;

        for (int i = left; i <= right; i++) {
            if (hasEvenDisivors(i)) {
                result += i;
            } else {
                result -= i;
            }
        }

        return result;
    }
}

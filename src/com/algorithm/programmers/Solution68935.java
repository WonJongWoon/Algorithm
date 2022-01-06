package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/68935

class Solution68935 {

    private static int[] toThird(int value) {
        int len = (int) (Math.log10(value) / Math.log10(3)) + 1;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            result[i] = value % 3;
            value /= 3;
        }

        return result;
    }

    private static int toTen(int[] third) {
        int len = third.length;
        int result = 0;

        for (int i = 0; i < len; i++) {
            result += third[i] * (int) Math.pow(3, len - i - 1);
        }

        return result;
    }

    public int solution(int n) {
        return toTen(toThird(n));
    }
}

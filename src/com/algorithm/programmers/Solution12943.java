package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/04
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12943

class Solution12943 {

    public int solution(int num) {
        int count = 0;
        long value = num;

        while (value != 1 && count++ < 500) {
            if (value % 2 == 0) {
                value /= 2;
            } else {
                value = 3 * value + 1;
            }
        }

        return value == 1 && count < 500 ? count : -1;
    }
}

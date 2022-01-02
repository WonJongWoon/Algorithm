package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/02
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12931

class Solution12931 {

    public int solution(int n) {
        int result = 0;

        while (n != 0) {
            result += (n % 10);
            n /= 10;
        }

        return result;
    }
}

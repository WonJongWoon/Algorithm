package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/02
// Problem : https://programmers.co.kr/learn/courses/30/lessons/87389

class Solution87389 {

    public int solution(int n) {
        int result = 0;

        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                result = i;
                break;
            }
        }

        return result;
    }
}

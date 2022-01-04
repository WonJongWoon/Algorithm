package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/04
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12947

class Solution12947 {

    public boolean solution(int x) {
        int sum = 0, v = x;

        while (v != 0) {
            sum += (v % 10);
            v /= 10;
        }

        return x % sum == 0;
    }
}

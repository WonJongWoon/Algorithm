package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12934

class Solution12934 {

    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        return Math.floor(sqrt) == sqrt ? (long) Math.pow(sqrt + 1, 2) : -1L;
    }
}

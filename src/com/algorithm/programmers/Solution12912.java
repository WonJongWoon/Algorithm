package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/03
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12912

import java.util.stream.LongStream;

class Solution12912 {

    public long solution(int a, int b) {
        return LongStream.rangeClosed(Math.min(a, b), Math.max(a, b)).sum();
    }
}

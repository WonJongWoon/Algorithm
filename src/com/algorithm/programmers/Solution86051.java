package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/03
// Problem : https://programmers.co.kr/learn/courses/30/lessons/86051

import java.util.Arrays;

class Solution86051 {

    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }
}

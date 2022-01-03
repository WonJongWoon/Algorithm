package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/03
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12944

import java.util.Arrays;

class Solution12944 {

    public double solution(int[] arr) {
        return (double) Arrays.stream(arr).sum() / arr.length;
    }
}

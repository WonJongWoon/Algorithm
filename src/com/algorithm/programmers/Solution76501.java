package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/02
// Problem : https://programmers.co.kr/learn/courses/30/lessons/76501

import java.util.stream.IntStream;

class Solution76501 {

    public static int sign(boolean sign) {
        return sign ? 1 : -1;
    }

    public int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, absolutes.length).map(i -> absolutes[i] * sign(signs[i])).sum();
    }
}

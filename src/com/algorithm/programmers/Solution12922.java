package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/03
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12922

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution12922 {

    public String solution(int n) {
        final String[] WORDS = {"수", "박"};
        return IntStream.range(0, n).mapToObj(i -> WORDS[i % 2]).collect(Collectors.joining());
    }
}

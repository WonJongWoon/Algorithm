package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/04
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12917

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution12917 {

    public String solution(String s) {
        return Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).collect(
            Collectors.joining());
    }
}

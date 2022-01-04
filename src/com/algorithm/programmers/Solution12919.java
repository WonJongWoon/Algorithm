package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/04
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12919

import java.util.Arrays;

class Solution12919 {

    public String solution(String[] seoul) {
        return String.format("김서방은 %d에 있다", Arrays.asList(seoul).indexOf("Kim"));
    }
}

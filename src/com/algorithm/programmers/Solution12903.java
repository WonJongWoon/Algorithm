package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/03
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12903

class Solution12903 {

    public String solution(String s) {
        return s.substring((s.length() - 1) / 2, (s.length() / 2) + 1);
    }
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/03
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12916

class Solution12916 {

    public boolean solution(String s) {
        return s.chars().filter(c -> c == 'P' || c == 'p').count() == s.chars()
            .filter(c -> c == 'y' || c == 'Y').count();
    }
}

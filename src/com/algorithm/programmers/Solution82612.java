package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/01
// Problem : https://programmers.co.kr/learn/courses/30/lessons/82612

public class Solution82612 {

    public long solution(int price, int money, int count) {
        return Math.max(((count * (count + 1)) >> 1) * price - money, 0);
    }
}

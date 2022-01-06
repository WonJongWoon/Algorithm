package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12921

import java.util.stream.IntStream;

class Solution12921 {

    private static boolean isPrime(int value) {
        for (int i = 2; i <= (int) Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int solution(int n) {
        return (int) IntStream.rangeClosed(2, n).filter(Solution12921::isPrime).count();
    }
}

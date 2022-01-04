package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/04
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12940

import java.math.BigInteger;

class Solution12940 {

    private static int gcd(int n, int m) {
        return BigInteger.valueOf(n).gcd(BigInteger.valueOf(m)).intValue();
    }

    private static int lcd(int n, int m) {
        return n * (m / gcd(n, m));
    }

    public int[] solution(int n, int m) {
        return new int[]{gcd(n, m), lcd(n, m)};
    }
}

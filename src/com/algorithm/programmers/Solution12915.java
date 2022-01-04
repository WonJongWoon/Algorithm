package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/04
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12915

import java.util.Arrays;

class Solution12915 {

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
                if (s1.charAt(n) == s2.charAt(n)) {
                    return s1.compareTo(s2);
                }

                return s1.charAt(n) - s2.charAt(n);
            }
        );

        return strings;
    }
}

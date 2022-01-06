package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12982

import java.util.Arrays;

class Solution12982 {

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int result = 0;

        for (int cost : d) {
            if (budget - cost >= 0) {
                budget -= cost;
                result++;
            } else {
                break;
            }
        }

        return result;
    }
}

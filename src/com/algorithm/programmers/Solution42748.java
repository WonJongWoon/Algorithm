package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2021/12/31
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42748

import java.util.Arrays;

class Solution42748 {

    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0], j = commands[idx][1], k = commands[idx][2];
            int[] sub = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(sub);
            result[idx] = sub[k - 1];
        }

        return result;
    }
}

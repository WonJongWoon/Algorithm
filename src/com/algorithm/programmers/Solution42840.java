package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/05
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42840

import java.util.stream.IntStream;

class Solution42840 {

    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] oks = new int[3];

        for (int i = 0; i < answers.length; i++) {
            oks[0] += (first[i % 5] == answers[i] ? 1 : 0);
            oks[1] += (second[i % 8] == answers[i] ? 1 : 0);
            oks[2] += (third[i % 10] == answers[i] ? 1 : 0);
        }

        int max = Math.max(Math.max(oks[0], oks[1]), oks[2]);
        return IntStream.range(0, 3).filter(i -> oks[i] == max).map(i -> i + 1).toArray();
    }
}

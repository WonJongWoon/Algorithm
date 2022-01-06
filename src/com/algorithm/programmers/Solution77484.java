package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/77484

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution77484 {

    public int[] solution(int[] lottos, int[] winNums) {
        Set<Integer> nust = Arrays.stream(lottos).filter(lotto -> lotto != 0).boxed()
            .collect(Collectors.toSet());
        int erase = lottos.length - nust.size();

        int collect = 0;
        final int[] RANKS = {6, 6, 5, 4, 3, 2, 1};

        for (int winNum : winNums) {
            if (nust.contains(winNum)) {
                nust.remove(winNum);
                collect++;
            }
        }

        return new int[]{RANKS[collect + erase], RANKS[collect]};
    }
}

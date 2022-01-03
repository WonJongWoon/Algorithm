package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/03
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12954

import java.util.ArrayList;
import java.util.List;

class Solution12954 {

    public long[] solution(int x, int n) {
        List<Long> result = new ArrayList<>();
        result.add((long) x);

        while (result.size() < n) {
            result.add(result.get(result.size() - 1) + (long) x);
        }

        return result.stream().mapToLong(Long::longValue).toArray();
    }
}

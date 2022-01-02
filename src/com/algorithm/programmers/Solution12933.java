package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/02
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12933

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.LongStream;

class Solution12933 {

    public long solution(long n) {
        List<Integer> elements = new ArrayList<>();

        while (n != 0) {
            elements.add((int) (n % 10));
            n /= 10;
        }

        Collections.sort(elements);
        return LongStream.range(0L, elements.size())
            .map(i -> (elements.get((int) i) * (long) Math.pow(10L, i))).sum();
    }
}


package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/01
// Problem : https://programmers.co.kr/learn/courses/30/lessons/68644

import java.util.HashSet;
import java.util.Set;

public class Solution68644 {

    public int[] solution(int[] numbers) {
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}

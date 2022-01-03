package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/03
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12906

import java.util.Stack;

class Solution12906 {

    public int[] solution(int[] arr) {
        Stack<Integer> result = new Stack<>();

        for (int v : arr) {
            if (!result.isEmpty() && result.peek() == v) {
                continue;
            }
            result.push(v);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

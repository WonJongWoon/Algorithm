package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/02
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12910

import java.util.Arrays;

class Solution12910 {

    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(element -> element % divisor == 0).sorted()
            .toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }
}

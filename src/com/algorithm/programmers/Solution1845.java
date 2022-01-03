package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/03
// Problem : https://programmers.co.kr/learn/courses/30/lessons/1845

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution1845 {

    public int solution(int[] nums) {
        Set<Integer> nest = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Math.min(nest.size(), nums.length / 2);
    }
}

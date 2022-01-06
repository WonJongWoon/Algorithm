package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/86491

class Solution86491 {

    public int solution(int[][] sizes) {
        int maxWidth = -1, maxHeight = -1;

        for (int[] size : sizes) {
            maxWidth = Math.max(Math.min(size[0], size[1]), maxWidth);
            maxHeight = Math.max(Math.max(size[0], size[1]), maxHeight);
        }

        return maxWidth * maxHeight;
    }
}

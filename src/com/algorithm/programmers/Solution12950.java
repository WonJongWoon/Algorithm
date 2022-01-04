package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/04
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12950

class Solution12950 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr1[0].length];

        for (int row = 0; row < arr1.length; row++) {
            for (int col = 0; col < arr1[0].length; col++) {
                result[row][col] = arr1[row][col] + arr2[row][col];
            }
        }

        return result;
    }
}

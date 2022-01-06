package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/17681

class Solution17681 {

    private static int[] toBinary(int value, int length) {
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[length - i - 1] = value % 2;
            value /= 2;
        }

        return result;
    }

    private static String toString(int[] binary) {
        StringBuilder result = new StringBuilder();
        final char[] TILES = {' ', '#'};

        for (int bit : binary) {
            result.append(TILES[bit]);
        }

        return result.toString();
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for (int row = 0; row < n; row++) {
            result[row] = toString(toBinary(arr1[row] | arr2[row], n));
        }

        return result;
    }
}

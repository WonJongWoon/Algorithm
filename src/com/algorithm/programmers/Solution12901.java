package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/04
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12901

class Solution12901 {

    public String solution(int a, int b) {
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        final String[] DAY = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int sum = -1;

        for (int month = 1; month < a; month++) {
            sum += days[month - 1];
        }

        sum += b;
        return DAY[sum % 7];
    }
}

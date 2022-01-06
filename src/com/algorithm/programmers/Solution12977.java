package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12977

class Solution12977 {

    private static boolean isPrime(int value) {
        for (int i = 2; i <= (int) Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int solution(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    result += (isPrime(nums[i] + nums[j] + nums[k]) ? 1 : 0);
                }
            }
        }

        return result;
    }
}

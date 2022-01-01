package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/01
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12918

public class Solution12918 {

    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && s.chars().allMatch(Character::isDigit);
    }
}

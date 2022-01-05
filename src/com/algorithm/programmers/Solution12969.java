package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/05
// Problem : https://programmers.co.kr/learn/courses/30/lessons/12969

import java.util.Scanner;

class Solution12969 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

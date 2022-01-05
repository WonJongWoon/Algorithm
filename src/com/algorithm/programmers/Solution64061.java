package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/05
// Problem : https://programmers.co.kr/learn/courses/30/lessons/64061

import java.util.Stack;

class Solution64061 {

    public int solution(int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> buffer = new Stack<>();

        for (int move : moves) {
            int col = move - 1;

            for (int row = 0; row < board[0].length; row++) {
                int doll = board[row][col];

                if (doll != 0) {
                    board[row][col] = 0;

                    if (!buffer.isEmpty() && buffer.peek() == doll) {
                        buffer.pop();
                        answer += 2;
                        break;
                    }

                    buffer.push(doll);
                    break;
                }
            }
        }

        return answer;
    }
}

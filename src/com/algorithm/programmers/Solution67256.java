package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/03
// Problem : https://programmers.co.kr/learn/courses/30/lessons/67256

class Solution67256 {

    private static class Position {

        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Position other) {
            return Math.abs(other.x - this.x) + Math.abs(other.y - this.y);
        }

    }

    public String solution(int[] numbers, String hand) {
        Position leftHand = new Position(3, 0), rightHand = new Position(3, 2);
        StringBuilder result = new StringBuilder(numbers.length);

        for (int number : numbers) {
            int pos = number == 0 ? 10 : number - 1;
            int row = pos / 3, col = pos % 3;
            Position target = new Position(row, col);

            if (col == 0) {
                leftHand.move(row, col);
                result.append("L");
            } else if (col == 2) {
                rightHand.move(row, col);
                result.append("R");
            } else if (target.distance(leftHand) < target.distance(rightHand)) {
                leftHand.move(row, col);
                result.append("L");
            } else if (target.distance(leftHand) > target.distance(rightHand)) {
                rightHand.move(row, col);
                result.append("R");
            } else if ("right".equals(hand)) {
                rightHand.move(row, col);
                result.append("R");
            } else {
                leftHand.move(row, col);
                result.append("L");
            }
        }

        return result.toString();
    }
}

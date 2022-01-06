package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/06
// Problem : https://programmers.co.kr/learn/courses/30/lessons/72410

import java.util.Stack;

class Solution72410 {

    private static boolean isCheckEmptyOrPoint(String id) {
        return "".equals(id) || ".".equals(id);
    }

    private static String toLowerCase(String id) {
        return id.toLowerCase();
    }

    private static String eraseDenyPattern(String id) {
        StringBuilder result = new StringBuilder();

        for (char c : id.toCharArray()) {
            if ((Character.isLowerCase(c) && Character.isLetter(c)) || Character.isDigit(c)
                || c == '-' || c == '_' || c == '.') {
                result.append(c);
            }
        }

        return result.toString();
    }

    private static String eraseContinuousPoint(String id) {
        Stack<Integer> stack = new Stack<>();

        for (char c : id.toCharArray()) {
            if (c == '.') {
                if (!stack.isEmpty() && stack.peek() == c) {
                    continue;
                }

                stack.push((int) c);
                continue;
            }

            stack.push((int) c);
        }

        StringBuilder result = new StringBuilder();

        for (int v : stack) {
            result.append((char) v);
        }

        return result.toString();
    }

    private static String leftTrimPoint(String id) {
        if (isCheckEmptyOrPoint(id)) {
            return "";
        }

        return id.charAt(0) == '.' ? id.substring(1) : id;
    }

    private static String rightTrimPoint(String id) {
        if (isCheckEmptyOrPoint(id)) {
            return "";
        }

        return id.charAt(id.length() - 1) == '.' ? id.substring(0, id.length() - 1) : id;
    }

    private static String trimPoint(String id) {
        return leftTrimPoint(rightTrimPoint(id));
    }

    private static String requireNonEmpty(String id) {
        return id.length() == 0 ? "a" : id;
    }

    private static String cutOver(String id, int len) {
        if (id.length() >= len) {
            return rightTrimPoint(id.substring(0, len - 1));
        }

        return id;
    }

    private static String lastLetterRepeat(String id, int len) {
        if (id.length() <= 2) {
            StringBuilder result = new StringBuilder(id);
            for (int i = 1; i <= len - id.length(); i++) {
                result.append(id.charAt(id.length() - 1));
            }

            return result.toString();
        }

        return id;
    }

    public String recommandIdFrom(String id) {
        String first = toLowerCase(id);
        String second = eraseDenyPattern(first);
        String third = eraseContinuousPoint(second);
        String fourth = trimPoint(third);
        String fifth = requireNonEmpty(fourth);
        String sixth = cutOver(fifth, 16);
        return lastLetterRepeat(sixth, 3);
    }

    public String solution(String newId) {
        return recommandIdFrom(newId);
    }
}

package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2021/12/31
// Problem : https://programmers.co.kr/learn/courses/30/lessons/81301

import java.util.HashMap;
import java.util.Map;

class Solution81301 {

    private static class Word {

        private final String body;
        private final int value;

        public Word(String body, int value) {
            this.body = body;
            this.value = value;
        }

        public int getLength() {
            return this.body.length();
        }

        public int getValue() {
            return this.value;
        }
    }

    public Map<String, Word> getLens() {
        Map<String, Word> lens = new HashMap<>();
        lens.put("ze", new Word("zero", 0));
        lens.put("on", new Word("one", 1));
        lens.put("tw", new Word("two", 2));
        lens.put("th", new Word("three", 3));
        lens.put("fo", new Word("four", 4));
        lens.put("fi", new Word("five", 5));
        lens.put("si", new Word("six", 6));
        lens.put("se", new Word("seven", 7));
        lens.put("ei", new Word("eight", 8));
        lens.put("ni", new Word("nine", 9));
        return lens;
    }

    public int solution(String s) {
        int answer = 0;

        StringBuilder sb = new StringBuilder(100);
        Map<String, Word> lens = getLens();

        int start = 0;

        while (start < s.length()) {
            char v = s.charAt(start);
            if (Character.isDigit(v)) {
                sb.append(v);
                start++;
            } else if (Character.isLetter(s.charAt(start)) && (start + 1) < s.length()) {
                Word word = lens.get(s.substring(start, start + 2));
                sb.append(word.getValue());
                start += word.getLength();
            }
        }

        return Integer.parseInt(sb.toString());
    }
}

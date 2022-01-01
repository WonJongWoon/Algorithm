package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2021/12/30
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42626

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution42626 {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = Arrays.stream(scoville).boxed()
            .collect(Collectors.toCollection(PriorityQueue::new));

        int result = 0;

        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + 2 * second);
            result++;
        }

        return pq.peek() < K ? -1 : result;
    }
}

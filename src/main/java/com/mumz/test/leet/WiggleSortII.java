package com.mumz.test.leet;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class WiggleSortII {

    public static void wiggleSort(int[] nums) {
        final Queue<Integer> priorityQueue = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        for (int i : nums) priorityQueue.add(i);
        for (int i = 1; i < nums.length; i += 2) nums[i] = priorityQueue.poll();

        for (int i = 1; i < nums.length; i += 2) nums[i] = priorityQueue.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
    }
}

package com.mumz.test.leet;

import java.util.Deque;
import java.util.LinkedList;

public class SmallestSubArrayWithTargetSum {

    static class Window {
        long windowSum;
        int index;

        public Window(long windowSum,
                      int index) {
            this.windowSum = windowSum;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Window{" +
                   "windowSum=" + windowSum +
                   ", index=" + index +
                   '}';
        }
    }

    public static int shortestSubarray(
            int[] nums,
            int k
    ) {
        if (nums[0] == k) return 1;
        int smallestLength = Integer.MAX_VALUE;
        final Deque<Window> windowDeque = new LinkedList<>();
        long currentRunningSum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentRunningSum += nums[windowEnd];
            if (currentRunningSum >= k) smallestLength = Math.min(smallestLength, windowEnd + 1);

            Window curr = null;
            while (!windowDeque.isEmpty() && currentRunningSum - windowDeque.peekFirst().windowSum >= k) {
                curr = windowDeque.peekFirst();
                windowDeque.removeFirst();
            }

            if (curr != null) smallestLength = Math.min(smallestLength, windowEnd - curr.index);

            while (!windowDeque.isEmpty() && currentRunningSum < windowDeque.peekLast().windowSum)
                windowDeque.removeLast();

            windowDeque.addLast(new Window(currentRunningSum, windowEnd));
        }
        return smallestLength == Integer.MAX_VALUE ? -1 : smallestLength;
    }

    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167));
        System.out.println(shortestSubarray(new int[]{1, 2}, 4));
        System.out.println(shortestSubarray(new int[]{2, -1, 2}, 3));
    }
}

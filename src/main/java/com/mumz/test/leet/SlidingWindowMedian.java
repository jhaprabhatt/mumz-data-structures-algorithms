package com.mumz.test.leet;

import java.util.PriorityQueue;

public class SlidingWindowMedian {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public double[] medianSlidingWindow(
            int[] nums,
            int k
    ) {
        if (nums == null || nums.length == 0 || k <= 0) return new double[0];
        initializeHeaps();
        var medians = new double[nums.length - (k - 1)];
        var windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            addNum(nums[windowEnd]);
            if (windowEnd - windowStart >= k - 1) {
                medians[windowStart] = findMedian();
                remove(nums[windowStart]);
                windowStart++;
            }
        }
        return medians;
    }

    private void initializeHeaps() {
        maxHeap = new PriorityQueue<>((o1, o2) -> -1 * o1.compareTo(o2));
        minHeap = new PriorityQueue<>();
    }

    private void remove(int num) {
        if (maxHeap.contains(num)) maxHeap.remove(num);
        else minHeap.remove(num);
        rebalance();
    }

    private void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() > num) maxHeap.add(num);
        else minHeap.add(num);
        rebalance();
    }

    private void rebalance() {
        var bigger = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        var smaller = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
        if (bigger.size() - smaller.size() > 1) smaller.add(bigger.poll());
    }

    private double findMedian() {
        var bigger = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        var smaller = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
        if (bigger.size() == smaller.size()) return (double) ((long) bigger.peek() + (long) smaller.peek()) / 2;
        else return bigger.peek();
    }

    private static void executeAndDisplay(
            SlidingWindowMedian slidingWindowMedian,
            int[] x,
            int k
    ) {
        for (double v : slidingWindowMedian.medianSlidingWindow(x, k)) {
            System.out.println(v);
        }
    }

    public int search(int[] nums,
                      int target) {
        if (nums == null || nums.length == 0) return -1;
        var left = 0;
        var right = nums.length - 1;
        while (left <= right) {
            var leftItem = nums[left];
            var rightItem = nums[right];
            if (target - leftItem == 0) return left;
            if (target - rightItem == 0) return right;
            if (leftItem < target) left++;
            if (rightItem > target) right--;
        }
        return -1;
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        executeAndDisplay(slidingWindowMedian, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, 2);
        executeAndDisplay(slidingWindowMedian, new int[]{2, 3, 4}, 3);
        executeAndDisplay(slidingWindowMedian, new int[]{1, 2, 3, 4}, 3);
        executeAndDisplay(slidingWindowMedian, new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        executeAndDisplay(slidingWindowMedian, new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}

package com.mumz.test.leet;

import java.util.PriorityQueue;

public class MedianFinder {

    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((o1, o2) -> -1 * o1.compareTo(o2));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        rebalance();
    }

    private void rebalance() {
        PriorityQueue<Integer> bigger = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Integer> smaller = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
        if (bigger.size() - smaller.size() > 1) {
            smaller.add(bigger.poll());
        }
    }

    public double findMedian() {
        PriorityQueue<Integer> bigger = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Integer> smaller = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
        if (bigger.size() == smaller.size()) {
            return (double) (bigger.peek() + smaller.peek()) / 2;
        } else {
            return bigger.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

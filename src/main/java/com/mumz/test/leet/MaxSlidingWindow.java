package com.mumz.test.leet;

import java.util.*;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(
            int[] nums,
            int k
    ) {
        var max = new PriorityQueue<Integer>((first, second) -> -1 * first.compareTo(second));
        var maxes = new int[nums.length - (k - 1)];
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            max.add(nums[windowEnd]);
            if (windowEnd >= k - 1) {
                maxes[windowEnd - (k - 1)] = max.peek();
                max.remove(nums[windowEnd - (k - 1)]);
            }
        }
        return maxes;
    }

    public static int[] topKFrequent(int[] nums,
                                     int k) {
        int[] result = new int[k];
        var numberFrequenceMap = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numberFrequenceMap.put(nums[i], numberFrequenceMap.getOrDefault(nums[i], 0) + 1);
        }
        var entries = new ArrayList<>(numberFrequenceMap.entrySet());
        Collections.sort(entries, Comparator.comparing(Map.Entry::getValue));
        var index = 0;
        for (int i = entries.size() - 1; i >= 0 && index < k; i--) {
            result[index] = entries.get(i).getKey();
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)) {
            System.out.println(i);
        }
    }
}

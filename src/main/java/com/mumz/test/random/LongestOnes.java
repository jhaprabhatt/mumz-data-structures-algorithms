package com.mumz.test.random;

public class LongestOnes {

    public static int longestOnes(int[] nums,
                                  int k) {
        int windowStart = 0;
        int count = 0;
        int longestOnes = Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 0) count++;
            while (count > k && windowStart <= windowEnd) {
                if (nums[windowStart] == 0) count--;
                windowStart++;
            }
            longestOnes = Math.max(longestOnes, windowEnd - windowStart + 1);
        }
        return longestOnes;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0, 0, 0, 0}, 0));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 1, 0, 0}, 0));
    }
}

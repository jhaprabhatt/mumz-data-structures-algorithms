package com.mumz.test.leet;

public class SmallestSubArrayWithTargetSum {

    public static int shortestSubarray(
            int[] nums,
            int k
    ) {
        if (nums[0] == k) return 1;
        int smallestLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int currentRunningLength = 0;
        int currentRunningSum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentRunningSum += nums[windowEnd];
            while (currentRunningSum >= k && windowStart <= windowEnd) {
                smallestLength = Math.min(smallestLength, windowEnd - windowStart + 1);
                currentRunningSum -= nums[windowStart];
                windowStart++;
            }
        }
        return smallestLength == Integer.MAX_VALUE ? -1 : smallestLength;
    }

    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{84, -37, 32, 40, 95}, 210));
    }
}

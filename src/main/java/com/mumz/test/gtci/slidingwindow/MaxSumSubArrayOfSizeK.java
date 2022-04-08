package com.mumz.test.gtci.slidingwindow;

import java.util.Arrays;

public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(
            int k,
            int[] arr
    ) {
        if (k <= 0 || arr == null || arr.length == 0) return 0;
        int maxSumSubArray = Integer.MIN_VALUE;
        int currentRunningSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentRunningSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                maxSumSubArray = Math.max(maxSumSubArray, currentRunningSum);
                currentRunningSum -= arr[windowEnd - (k - 1)];
            }
        }
        return maxSumSubArray;
    }

    public static void main(String[] args) {
        /*System.out.println(findMaxSumSubArray(-1, new int[]{2, 1, 5, 1, 3, 2}) == 0);
        System.out.println(findMaxSumSubArray(0, new int[]{2, 1, 5, 1, 3, 2}) == 0);
        System.out.println(findMaxSumSubArray(3, null) == 0);
        System.out.println(findMaxSumSubArray(3, new int[4]) == 0);*/
        System.out.println(findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}) == 9);
        System.out.println(findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}) == 7);
    }
}

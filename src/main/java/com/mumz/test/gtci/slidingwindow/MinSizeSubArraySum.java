package com.mumz.test.gtci.slidingwindow;

public class MinSizeSubArraySum {
    public static int findMinSubArray(
            final int S,
            final int[] arr
    ) {
        if (S <= 0 || arr == null || arr.length == 0) return 0;
        int minSubArraySum = Integer.MAX_VALUE;
        int windowStart = 0;
        int currentRunningSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentRunningSum += arr[windowEnd];
            while (currentRunningSum >= S) {
                minSubArraySum = Math.min(minSubArraySum, windowEnd - windowStart + 1);
                currentRunningSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minSubArraySum == Integer.MAX_VALUE ? 0 : minSubArraySum;
    }

    public static void main(String[] args) {
        executeEdgeCases();
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}) == 2);
    }

    private static void executeEdgeCases() {
        System.out.println(findMinSubArray(-1, new int[]{2, 1, 5, 2, 3, 2}) == 0);
        System.out.println(findMinSubArray(0, new int[]{2, 1, 5, 2, 3, 2}) == 0);
        System.out.println(findMinSubArray(7, null) == 0);
        System.out.println(findMinSubArray(7, new int[]{}) == 0);
    }
}

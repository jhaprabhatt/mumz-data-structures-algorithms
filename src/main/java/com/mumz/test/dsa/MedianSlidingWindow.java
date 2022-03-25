package com.mumz.test.dsa;

public class MedianSlidingWindow {

    public static double[] medianSlidingWindow(
            int[] nums,
            int k
    ) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return new double[]{};
        double[] medians = new double[nums.length - k];

        for (int windowEnd = 0; windowEnd < nums.length - k; windowEnd++) {
            int counter = windowEnd;
            int sum = 0;
            for (int windowStart = 0; windowStart < k; windowStart++) {
                sum += nums[counter];
                counter++;
            }
            medians[windowEnd] = (double) sum / k;
        }
        // write your code here
        return medians;
    }

    public static void main(String[] args) {
        for (double v : medianSlidingWindow(new int[]{1, 3, -1, 2, -2, -3, 5, 1, 5, 3}, 3)) {
            System.out.print(v + ",");
        }
    }
}

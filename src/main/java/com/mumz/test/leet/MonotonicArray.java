package com.mumz.test.leet;

public class MonotonicArray {

    public static boolean isMonotonic(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        boolean increasing = nums[0] <= nums[1];
        int prev = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (increasing && nums[i] < prev) return false;
            else if (!increasing && nums[i] > prev) return false;
            else prev = nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(isMonotonic(new int[]{1, 3, 2}));
    }
}

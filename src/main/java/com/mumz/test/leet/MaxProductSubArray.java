package com.mumz.test.leet;

public class MaxProductSubArray {

    public static int maxProduct(int[] nums) {

        int maxSubProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        for (int windowEnd = 1; windowEnd < nums.length; windowEnd++) {

            if (nums[windowEnd] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            currentMax = Math.max(nums[windowEnd], nums[windowEnd] * currentMax);
            currentMin = Math.min(nums[windowEnd], nums[windowEnd] * currentMin);
            maxSubProduct = Math.max(maxSubProduct, currentMax);
        }

        return maxSubProduct;
    }

    public static void main(String[] args) {
        int num = 4;
        for (int i = 1; i * i <= num; i++) {
            if ((num % i == 0) && (num / i == i)) {
                System.out.println(true);
            }
        }
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
    }
}

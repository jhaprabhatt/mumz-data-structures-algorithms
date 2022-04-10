package com.mumz.test.misc;

public class MaximumProduct {

    static long maxProduct(
            int[] arr,
            int n
    ) {
        if (arr == null || n <= 0) return 0;
        long maxProduct = Long.MIN_VALUE;
        long windowProduct = arr[0];
        int windowStart = 0;
        for (int windowEnd = 1; windowEnd < n; windowEnd++) {
            windowProduct *= arr[windowEnd];
            while (windowProduct < maxProduct && windowStart < n) {
                if (arr[windowStart] == 0) windowProduct = 0;
                else windowProduct /= arr[windowStart];
                windowStart++;
            }
            maxProduct = Math.max(windowProduct, maxProduct);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{6, -3, -10, 0, 2}, 5));
        System.out.println(maxProduct(new int[]{2, 3, 4, 5, -1, 0}, 6));
        System.out.println(maxProduct(new int[]{1, -4}, 2));
    }
}

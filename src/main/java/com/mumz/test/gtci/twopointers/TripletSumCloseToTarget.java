package com.mumz.test.gtci.twopointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    public static int searchTriplet(
            int[] arr,
            int targetSum
    ) {
        if (arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);
        int maxElementCount = 3;
        int runningSum = 0;
        int noOfTriplets = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-2, 0, 1, 2};
        Arrays.sort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}

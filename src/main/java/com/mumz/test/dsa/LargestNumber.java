package com.mumz.test.dsa;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array, return the largest possible number using the contents of the array.
 * <p>
 * For e.g
 * <p>
 * Given: [1,30,45,89,9]
 * Return: 98945401
 */
public class LargestNumber {

    private static int largestNumber(int[] array) {
        if (array == null || array.length == 0) return 0;
        int count = 0;
        while (count < array.length) {
            for (int iDx = 0; iDx < array.length - 1; iDx++) {
                int currentItem = array[iDx];
                int nextItem = array[iDx + 1];
                int first = concatenate(currentItem, nextItem);
                int second = concatenate(nextItem, currentItem);
                if (first < second) {
                    swap(array, iDx, iDx + 1);
                }
            }
            count++;
        }
        int longestNumber = 0;
        for (int iDx = 0; iDx < array.length; iDx++) {
            int currentItem = array[iDx];
            longestNumber = concatenate(longestNumber, currentItem);
        }
        return longestNumber;
    }

    private static int concatenate(int a,
                                   int b) {
        if (b == 0) a *= 10;
        else {
            int temp = b;
            while (temp > 0) {
                temp /= 10;
                a *= 10;
            }
        }
        return a + b;
    }

    private static void swap(
            int[] array,
            int from,
            int to
    ) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{1, 30, 45, 89, 9}));
    }
}

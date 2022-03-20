package com.mumz.test.dsa;

/**
 * Given an array, find the number which appears only once. Return -1 if no such element exists
 * <p>
 * For e.g:
 * <p>
 * Given array : [1,3,4,5,2,3,5,2,4]
 * <p>
 * Return 1
 * <p>
 * Given array : [1,3,4,5,2,3,5,2,4,1]
 * <p>
 * Return -1
 */
public class SingleNumber {

    public static int singleNumberThroughXor(int[] array) {
        if (array == null || array.length == 0) return -1;
        int result = 0;
        for (int iDx = 0; iDx < array.length; iDx++)
            result ^= array[iDx];
        return result > 0 ? result : -1;
    }

    public static void main(String[] args) {
        System.out.println(singleNumberThroughXor(new int[]{1, 3, 4, 5, 2, 3, 5, 2, 4}));
        System.out.println(singleNumberThroughXor(new int[]{1, 3, 4, 5, 2, 3, 5, 2, 4, 1}));
    }
}

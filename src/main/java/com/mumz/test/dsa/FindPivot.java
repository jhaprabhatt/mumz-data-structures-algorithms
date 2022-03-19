package com.mumz.test.dsa;

/**
 * Pivot is the index at which sum of all elements to its left is equal to sum of all elements to its right.
 * <p>
 * Return -1 if no such index exists
 * <p>
 * Return the first left most index if multiple such exists
 * <p>
 * For e.g
 * <p>
 * Given array = [1,6,3,6,5,5]
 * Return index = 3
 */
public class FindPivot {

    private static int findPivot(int[] array) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        int sumLeft = array[left];
        int sumRight = array[right];
        while (left < right) {
            if (sumLeft < sumRight) {
                left++;
                sumLeft += array[left];
            } else if (sumRight < sumLeft) {
                right--;
                sumRight += array[right];
            }
            if (sumLeft == sumRight) return left + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPivot(new int[]{1, 6, 3, 6, 5, 5}));
    }
}

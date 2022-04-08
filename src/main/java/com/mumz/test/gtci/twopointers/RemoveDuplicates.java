package com.mumz.test.gtci.twopointers;

public class RemoveDuplicates {

    public static int remove(int[] arr) {
        int windowStart = 0;
        int nonDups = 0;
        for (int left = 0; left < arr.length; left++) {
            int right = left + 1;
            while (right < arr.length && arr[left] == arr[right]) {
                arr[right] = Integer.MIN_VALUE;
                right++;
            }
            left = right - 1;
            nonDups++;
        }
        return nonDups;
    }

    public static void main(String[] args) {
        System.out.println(remove(new int[]{2, 3, 3, 3, 6, 9, 9}) == 4);
        System.out.println(remove(new int[]{2, 2, 2, 11}) == 2);
    }
}

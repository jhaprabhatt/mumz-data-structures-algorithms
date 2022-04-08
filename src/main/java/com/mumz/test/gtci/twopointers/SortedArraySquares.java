package com.mumz.test.gtci.twopointers;

import java.util.Arrays;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            squares[i] = arr[i] * arr[i];
        }
        Arrays.sort(squares);
        return squares;
    }
}

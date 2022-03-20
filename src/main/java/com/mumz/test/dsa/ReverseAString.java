package com.mumz.test.dsa;

import java.util.Arrays;

public class ReverseAString {

    public static void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int left = 0, right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        check("hello".toCharArray(), "olleh".toCharArray());
        check("hannaH".toCharArray(), "Hannah".toCharArray());
    }

    private static void check(
            char[] input,
            char[] expected
    ) {
        reverseString(input);
        System.out.println(Arrays.equals(input, expected) ? "Correct" : "Incorrect");
    }
}

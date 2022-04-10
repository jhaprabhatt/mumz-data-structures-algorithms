package com.mumz.test.dsa;

import static java.util.Objects.isNull;

public class PalindromeString {

    public static boolean isPalindrome(String s) {
        if (isNull(s)) return false;
        if (s.isBlank()) return true;
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left <= right) {
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);
            if (charLeft < 97 || charLeft > 122) {
                left++;
                continue;
            } else if (charRight < 97 || charRight > 122) {
                right--;
                continue;
            }
            if (charLeft != charRight) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        if (isNull(s) || s.isBlank()) return false;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);
            if (charLeft != charRight) {
                if (
                        checkPalindrome(s, left + 1, right) ||
                        checkPalindrome(s, left, right - 1)
                ) return true;
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean checkPalindrome(
            final String string,
            int left,
            int right
    ) {
        while (left <= right) {
            char charLeft = string.charAt(left);
            char charRight = string.charAt(right);
            if (charLeft != charRight) {
                return false;

            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abc"));
    }
}

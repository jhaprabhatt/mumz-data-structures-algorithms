package com.mumz.test.dsa;

public class PalindromeNumber {

    private static int reverse(int x) {
        int reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse;
    }

    public static boolean isPalindrome(int x) {
        if (x / 10 == 0) return true;
        if (x < 0) return false;
        int reverse = reverse(x);
        return x == reverse;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(1000021));
    }
}

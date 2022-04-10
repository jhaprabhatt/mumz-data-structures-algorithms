package com.mumz.test.random;

public class AnagramsOfANumber {

    public static int getAnagram(String s) {
        if (s == null || s.length() <= 1) return 0;
        int count = 0;
        for (int i = 0, j = s.length() / 2; i < s.length() / 2 && j < s.length(); i++, j++) {
            if (s.charAt(i) != s.charAt(j)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getAnagram("123122"));
        System.out.println(getAnagram("133122"));
        System.out.println(getAnagram("1332122"));
        System.out.println(getAnagram("122122"));
    }
}

package com.mumz.test.dsa;

public class LengthofLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) return 0;
        s = s.trim();
        int endIndex = s.length() - 1;
        int count = 0;
        while (endIndex >= 0) {
            if (s.charAt(endIndex) == ' ') {
                return count;
            }
            count++;
            endIndex--;
        }
        return count;
    }

    public static void main(String[] args) {
        check("Hello World", 5);
        check("   fly me   to   the moon  ", 4);
        check("luffy is still joyboy", 6);
    }

    private static void check(
            final String string,
            final int expectedLength
    ) {
        System.out.println(lengthOfLastWord(string) == expectedLength ? "Correct" : "Incorrect");
    }
}

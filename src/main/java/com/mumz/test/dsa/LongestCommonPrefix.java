package com.mumz.test.dsa;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        char[] firstContents = strs[0].toCharArray();
        int index = 0;
        for (; index < firstContents.length; index++) {
            char current = firstContents[index];
            for (int i = 1; i < strs.length; i++) {
                try {
                    if (strs[i].charAt(index) != current) {
                        return getLongestCommonPrefix(index, firstContents);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    return getLongestCommonPrefix(index, firstContents);
                }
            }
        }
        return getLongestCommonPrefix(index, firstContents);
    }

    private static String getLongestCommonPrefix(
            int endIndex,
            char[] contents
    ) {
        String longestCommonPrefix = "";
        for (int i = 0; i < endIndex; i++) {
            longestCommonPrefix += contents[i];
        }
        return longestCommonPrefix;
    }

    public static void main(String[] args) {
        check(new String[]{"flower", "flow", "flight"}, "fl");
    }

    static void check(final String[] input,
                      final String expected) {
        System.out.println(longestCommonPrefix(input).equals(expected) ? "Correct" : "Incorrect");
    }
}

package com.mumz.test.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSubstring {
    public static List<Integer> findSubstring(
            String s,
            String[] words
    ) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) return Collections.emptyList();
        final List<Integer> subStringIndexes = new ArrayList<>();
        int singleWordLength = words[0].length();
        int readLength = singleWordLength * words.length;
        String subString ="";
        for (int windowEnd = 0; windowEnd < s.length() - readLength; windowEnd++) {
            subString += s.substring(windowEnd, windowEnd + readLength);
            List<String> sortedSplitByLength = splitBySize(subString, singleWordLength);
            int index = 0;
            for (int i = 0; i < words.length; i++) {

            }
        }
        return subStringIndexes;
    }

    private static List<String> splitBySize(
            final String string,
            final int length
    ) {
        List<String> words = new ArrayList<>(string.length() / length);
        for (int i = 0; i < string.length(); i = i + length) {
            words.add(string.substring(i, i + length));
        }
        return words;
    }

    public static void main(String[] args) {
        System.out.println("barfoothefoobarman".substring(0, 6));
        for (String barfoothefoobarman : splitBySize("barfoothefoobarman", 3)) {
            System.out.println(barfoothefoobarman);
        }
    }
}

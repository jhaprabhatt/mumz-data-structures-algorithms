package com.mumz.test.dsa;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        final Map<Character, Integer> dupsMap = new HashMap<>(s.length());
        final Map<Character, Integer> uniqueCharMap = new HashMap<>(s.length());
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char leftChar = s.charAt(windowEnd);
            if (uniqueCharMap.containsKey(leftChar)) {
                dupsMap.put(leftChar, windowEnd);
                uniqueCharMap.remove(leftChar);
            } else if (!dupsMap.containsKey(leftChar)) {
                uniqueCharMap.put(leftChar, windowEnd);
            }
        }
        return uniqueCharMap.isEmpty() ? -1 : uniqueCharMap.values()
                .stream().sorted().findFirst().get();
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}

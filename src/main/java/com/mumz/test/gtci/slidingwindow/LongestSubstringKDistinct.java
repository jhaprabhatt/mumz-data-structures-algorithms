package com.mumz.test.gtci.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static int findLength(
            String str,
            int k
    ) {
        if (str == null || str.trim().length() == 0 || k <= 0) return 0;
        int longestSubStringLength = Integer.MIN_VALUE;
        final Map<Character, Integer> characterCountMap = new HashMap<>();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            characterCountMap.put(rightChar, characterCountMap.getOrDefault(rightChar, 0) + 1);
            while (characterCountMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                characterCountMap.put(leftChar, characterCountMap.get(leftChar) - 1);
                if (characterCountMap.get(leftChar) <= 0) characterCountMap.remove(leftChar);
                windowStart++;
            }
            longestSubStringLength = Math.max(longestSubStringLength, windowEnd - windowStart + 1);
        }
        return longestSubStringLength;
    }

    public static int findLengthWithArray(
            String str,
            int k
    ) {
        if (str == null || str.trim().length() == 0 || k <= 0) return 0;
        int longestSubStringLength = Integer.MIN_VALUE;
        final int[] bitVector = new int[26];
        str = str.toLowerCase();
        int bitVectorFills = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            bitVector[rightChar - 'a'] = bitVector[rightChar - 'a'] + 1;
            if (bitVector[rightChar - 'a'] == 1) bitVectorFills++;
            while (bitVectorFills > k) {
                char leftChar = str.charAt(windowStart);
                bitVector[leftChar - 'a'] = bitVector[leftChar - 'a'] - 1;
                if (bitVector[leftChar - 'a'] < 0) bitVector[leftChar - 'a'] = 0;
                windowStart++;
                bitVectorFills--;
            }
            longestSubStringLength = Math.max(longestSubStringLength, windowEnd - windowStart + 1);
        }
        return longestSubStringLength == Integer.MAX_VALUE ? -1 : longestSubStringLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength(null, 3) == 0);
        System.out.println(findLength("araaci", -1) == 0);
        System.out.println(findLength("araaci", 2) == 4);

        System.out.println(findLengthWithArray(null, 3) == 0);
        System.out.println(findLengthWithArray("araaci", -1) == 0);
        System.out.println(findLengthWithArray("araaci", 2) == 4);
    }
}

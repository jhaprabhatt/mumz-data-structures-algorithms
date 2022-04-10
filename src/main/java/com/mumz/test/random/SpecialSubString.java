package com.mumz.test.random;

public class SpecialSubString {

    public static int getSpecialSubString(String s,
                                          int K,
                                          String charValue) {
        char[] Q = charValue.toCharArray();
        char[] P = s.toCharArray();
        int left = 0;
        int right = 0;
        int count = 0;
        int ans = 0;
        final int contentLength = P.length;
        while (right < contentLength) {
            while (right < contentLength && count <= K) {
                int pos = P[right] - 'a';
                if (Q[pos] == '0') {
                    if (count + 1 > K)
                        break;
                    else
                        count++;
                }
                right++;

                // update answer with subString length
                if (count <= K)
                    ans = Math.max(ans, right - left);
            }
            while (left < right) {

                // get position of character
                int pos = P[left] - 'a';

                left++;

                // check if character is
                // normal then decrement count
                if (Q[pos] == '0')

                    count--;

                if (count < K)
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getSpecialSubString("normal", 1, "00000000000000000000000000"));
    }
}

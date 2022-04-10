package com.mumz.test.dsa;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> res = new ArrayList<>();
            res.add(nums[i]);
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                res.add(nums[j]);
            }
            result.add(res);
        }
        return result;
    }

    private static void swap(int[] nums,
                             int a,
                             int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static int totalVowels(final String text,
                                  int len,
                                  int index) {
        if (len == 0) return 0;
        int count = 0;
        char upperCase = Character.toUpperCase(text.charAt(index));
        switch (upperCase) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                count++;
                break;
        }
        return count + totalVowels(text, len - 1, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(totalVowels("thisisrecursion", "thisisrecursion".length(), 0));
    }
}

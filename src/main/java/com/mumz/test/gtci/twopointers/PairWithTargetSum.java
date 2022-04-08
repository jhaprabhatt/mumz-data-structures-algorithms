package com.mumz.test.gtci.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairWithTargetSum {
    public static int[] search(
            int[] arr,
            int targetSum
    ) {
        int left = 0;
        int right = arr.length - 1;
        final List<Integer> result = new ArrayList<>();
        int runningSum = 0;
        while (left < right) {
            runningSum = arr[left] + arr[right];
            if (runningSum == targetSum) {
                result.add(left);
                result.add(right);
                left++;
                right--;
            } else if (runningSum > targetSum) right--;
            else if (runningSum < targetSum) left++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] result = search(new int[]{1, 2, 3, 4, 6}, 6);
        Arrays.stream(result).forEach(System.out::println);
        result = search(new int[]{2, 5, 9, 11}, 11);
        Arrays.stream(result).forEach(System.out::println);

    }
}

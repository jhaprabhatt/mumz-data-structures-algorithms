package com.mumz.test.leet;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BaseballGame {

    public int calPoints(String[] ops) {
        final int[] elements = new int[ops.length];
        int index = 0;
        for (String option : ops) {
            switch (option) {
                case "C":
                    if (index != 0) {
                        index--;
                        elements[index] = 0;
                    }
                    break;
                case "D":
                    if (index != 0) {
                        elements[index] = 2 * elements[index - 1];
                        index++;
                    }
                    break;
                case "+":
                    int current = elements[index - 1];
                    int prev = elements[index - 2];
                    elements[index] = current + prev;
                    index++;
                    break;
                default:
                    int value = Integer.parseInt(option);
                    elements[index] = value;
                    index++;
            }
        }
        return Arrays.stream(elements)
                .reduce(0, Integer::sum);
    }

    public static int[] twoSum(int[] numbers,
                               int target) {
        int low = 0;
        int high = numbers.length - 1;
        int currentSum;
        while (low <= high) {
            currentSum = numbers[low] + numbers[high];
            if (currentSum == target) return new int[]{low + 1, high + 1};
            if (currentSum < target) low++;
            if (currentSum > target) high--;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(new BaseballGame().calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}

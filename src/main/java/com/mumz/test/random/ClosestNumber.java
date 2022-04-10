package com.mumz.test.random;

import java.util.*;

public class ClosestNumber {

    public static List<Integer> closestNumbers(List<Integer> arr) {
        if (arr == null || arr.size() == 1) return arr;
        Collections.sort(arr, (o1, o2) -> {
            Integer abso1 = Math.abs(o1);
            Integer abso2 = Math.abs(o2);
            return abso1.compareTo(abso2) ;
        });
        int absoluteDiff = Integer.MAX_VALUE;
        List<Integer> closestNumbers = new ArrayList<>();
        int runningDiff = 0;
        for (int i = 1; i < arr.size(); i++) {
            runningDiff = Math.abs(arr.get(i)) - Math.abs(arr.get(i - 1));
            if (absoluteDiff > runningDiff) {
                absoluteDiff = runningDiff;
                if (!closestNumbers.isEmpty()) closestNumbers.clear();
                closestNumbers.add(arr.get(i - 1));
                closestNumbers.add(arr.get(i));
            } else if (absoluteDiff == runningDiff) {
                closestNumbers.add(arr.get(i - 1));
                closestNumbers.add(arr.get(i));
            }
        }
        return closestNumbers;
    }

    public static void main(String[] args) {
        closestNumbers(Arrays.asList(new Integer[]{-5, 15, 25, 71, 63}));
    }
}

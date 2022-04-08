package com.mumz.test.gtci.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EfficientJanitor {

    public static int efficientJanitor(List<Float> weight) {
        Collections.sort(weight);
        float targetWeight = 3.0f;
        int left = 0;
        int right = weight.size() - 1;
        int count = 0;
        float runningSum;
        while (left < right) {
            runningSum = weight.get(left) + weight.get(right);
            if (runningSum <= targetWeight) {
                left++;
                right--;
            } else right--;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(efficientJanitor(Arrays.asList(1.01f, 1.99f, 2.5f, 1.5f, 1.01f)));
    }
}

package com.mumz.test.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        if (n == 0) return Collections.emptyList();
        final List<String> returnVal = new ArrayList<>(n);
        for (int i = 1; i <= n; ) {
            int mod3 = i % 3;
            int mod5 = i % 5;
            if (mod3 == 0 && mod5 == 0) returnVal.add("FizzBuzz");
            else if (mod3 == 0) returnVal.add("Fizz");
            else if (mod5 == 0) returnVal.add("Buzz");
            else returnVal.add(String.valueOf(i));
            i++;
            while (i <= n && i % 3 != 0 && i % 5 != 0) {
                returnVal.add(String.valueOf(i));
                i++;
            }
        }
        return returnVal;
    }

    public static void main(String[] args) {

    }
}

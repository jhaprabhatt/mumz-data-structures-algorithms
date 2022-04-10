package com.mumz.test.dsa;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PowerOf {

    public static double myPow(double x,
                               int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        }
        return 1 / myPow(x, -n);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2, -2));
        System.out.println(myPow(0.00001, 2147483647));
        System.out.println(myPow(8.88023, 3));
    }
}

package com.mumz.test.dsa;

public class CountDigits {

    public static int countDigits(int number) {
        if (number / 10 == 0) return 1;
        int count = 0;
        while (number > 0) {
            number = number / 10;
            count++;
        }
        return count;
    }

    public static int countDigitsRecursive(int number) {
        if (number / 10 == 0) return 1;
        int count = countDigitsRecursive(number / 10);
        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(4598));
        System.out.println(countDigitsRecursive(4598));
    }
}

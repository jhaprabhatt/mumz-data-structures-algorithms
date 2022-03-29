package com.mumz.test.dsa;

public class SumofDigits {

    public static int sumOfDigits(int number) {
        if (number / 10 == 0) return number;
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
            if (number == 0 && sum / 10 != 0) {
                number = sum;
                sum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(1));
        System.out.println(sumOfDigits(10));
        System.out.println(sumOfDigits(11));
        System.out.println(sumOfDigits(21));
        System.out.println(sumOfDigits(4567));
    }
}

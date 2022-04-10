package com.mumz.test.random;

public class CalculatorMain {

    static class DisplayA implements Calculator {

        int x;

        @Override
        public void cal(int item) {
            x = item * item;
        }
    }

    static class DisplayB implements Calculator {

        int x;

        @Override
        public void cal(int item) {
            x = item / item;
        }
    }

    public static void main(String[] args) {
        DisplayA displayA = new DisplayA();
        DisplayB displayB = new DisplayB();
        displayA.x = 0;
        displayB.x = 0;
        displayA.cal(2);
        displayB.cal(2);
        System.out.println(displayA.x + " " + displayB.x);

        String s1 = "Hello ";
        s1 += "World";
        String s2 = "Hello";
        s2 += " ";
        s2 += "World";
        String s3 = s1.intern();
        String s4 = s2.intern();
        boolean b1 = s3 == s4;
        boolean b2 = s3.equals(s4);
        System.out.println(b1 + " " + b2);

        Integer number = 10;
        number++;
        assert number == null && number >=0;
        System.out.println(number);
    }
}

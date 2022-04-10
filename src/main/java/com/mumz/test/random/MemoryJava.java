package com.mumz.test.random;

public class MemoryJava {


    public static void main(String[] args) {

        decreaseNumberbyOne(2);
    }

    public static void decreaseNumberbyOne(int num) {

        if (num >= 0) {

            decreaseNumberbyOne(num - 1);
        }

        System.out.println("Number:" + num);
    }

}

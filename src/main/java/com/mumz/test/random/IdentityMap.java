package com.mumz.test.random;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.*;

public class IdentityMap {

    static class Color {
        private String name;

        public Color(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            return true;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    public static void main(String[] args) {
        Map<Color, String> colorMap = new HashMap<>();
        colorMap.put(new Color("Red"), "Red");
        colorMap.put(new Color("Green"), "Green");
        colorMap.put(new Color("Blue"), "Blue");
        System.out.println(colorMap.size());
        System.out.println(colorMap.get(new Color("Red")));
/*
        Comparator<Integer> numberComparator = Comparator.naturalOrder();
        Integer[] arr = {1, 4, 3, 2};
        Arrays.sort(arr, numberComparator);
        for (Integer integer : arr) {
            System.out.println(integer);
        }
        */
        /*try {
            divide(3, 0);
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        } catch (Exception e) {
            System.out.println("Exception");
        }finally {
            System.out.println("Finally");
        }*/
//        System.out.println(method());
        /*Test<String> first = new Test<>("Hello");
        Test<Integer> second = new Test<>(2);
        System.out.println(first.getValue() + " " + second.getValue());*/

//        Set<? extends IOException> set = new HashSet<FileNotFoundException>();
    }

    static class Test<T> {
        T value;

        public Test(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public static Object method() {
        try {
            return 10 / 0;
        } catch (ArithmeticException e) {
            return "catch";
        } finally {
            return "finally";
        }
    }

    static void divide(int a,
                       int b) {
        try {
            int c = a / b;
        } finally {
            System.out.println("Finally");
        }
    }
}

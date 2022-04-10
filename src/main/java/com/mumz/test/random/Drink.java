package com.mumz.test.random;

import java.util.TreeSet;

public class Drink implements Comparable{

    public String name;
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Drink{" +
               "name='" + name + '\'' +
               '}';
    }

    public static void main(String[] args) {
        Drink one = new Drink();
        Drink two = new Drink();
        one.name = "Coffee";
        two.name = "Tea";

        TreeSet set = new TreeSet();
        set.add(one);
        set.add(two);

        for (Object o : set) {
            System.out.println(o);
        }
    }
}

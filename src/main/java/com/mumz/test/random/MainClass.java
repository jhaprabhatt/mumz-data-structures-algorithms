package com.mumz.test.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainClass {

    static class Animal {
    }

    static class Dog extends Animal {
    }

    static class Labrador extends Dog {
    }

    static void printValue(Animal a) {System.out.println("ONE");}

    static void printValue(Dog a) {System.out.println("TWO");}

    static void printValue(Object a) {System.out.println("THREE");}

    static class Person {
        String name;
        int age;

        public Person(String name,
                      int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        /*Person p1 = new Person("A",10);
        Person p2 = new Person("B",20);
        Person p3 = new Person("C",30);
        Person p4 = p1;
        Map<Person, Integer> personMap = new HashMap<>();
        personMap.put(p1, 1);
        personMap.put(p2, 2);
        personMap.put(p3, 3);
        personMap.put(p4, 4);
        System.out.println(personMap.size());*/
        /*Labrador l = new Labrador();
        printValue(l);*/
        /*int sum = 0;
        for (int i = 0, j = 0; i < 5 & j < 5; ++i, j = i + 1) {
            System.out.println(i + " " + j);
            sum += i;
        }
        System.out.println(sum);*/
        /*Object A = new Object();
        Object B = new Object();
        synchronized (A){
            synchronized (B) {
                synchronized (B){
                    System.out.println("Hello World");
                }
            }
        }*/
//        System.out.println(so())
//        ;
//        t();
//        String str = "java";
        Map<Integer, Object> simpleMap = new HashMap<>();
        simpleMap.put(1, null);
        simpleMap.put(5, null);
        simpleMap.put(3, null);
        simpleMap.put(2, null);
        simpleMap.put(4, null);
        System.out.println(simpleMap);
    }

    static void t() {
        try {
            System.out.println("Try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Exception");
            System.exit(1);
        } finally {
            System.out.println("Finally");
        }
    }

    static Object nullability() {
        Object o = new Float(3.14);
        Object[] oa = new Object[1];
        oa[0] = o;
        o = null;
        oa[0] = null;
        return o;
    }
}

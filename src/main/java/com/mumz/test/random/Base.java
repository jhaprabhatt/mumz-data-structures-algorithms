package com.mumz.test.random;

public class Base {
    static class A {

    }

    static class B extends A {

    }

    static class C extends B {

    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b instanceof B);
        System.out.println((b instanceof B) && (! (b instanceof C)));
        System.out.println((b instanceof B) && (! (b instanceof A)));
    }
}

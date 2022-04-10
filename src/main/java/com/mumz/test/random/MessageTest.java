package com.mumz.test.random;

public class MessageTest implements Runnable{

    public static void main(String[] args) {
        new Thread(new MessageTest()).start();
    }

    @Override
    public void run() {
        MyInnerClass.object.notify();
    }

    static class MyInnerClass{
        public static Object object = new Object();
    }
}

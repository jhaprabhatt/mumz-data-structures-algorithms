package com.mumz.test.random;

public class TestThread {

    static class MyThread extends Thread {
        MyThread() {}

        MyThread(Runnable r) {super(r);}

        public void run() {
            System.out.print("Inside Thread ");
        }
    }

    static class MyRunnable implements Runnable {
        public void run() {
            System.out.print(" Inside Runnable");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread(new MyRunnable()).start();
    }
}

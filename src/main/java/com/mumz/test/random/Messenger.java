package com.mumz.test.random;

public class Messenger implements Runnable {

    private final String name;

    public Messenger(String name) {

        this.name = name;
    }

    @Override
    public void run() {
        message(1);
        message(2);
    }

    private synchronized void message(int n) {
        System.out.println(name + "-" + n + " ");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Messenger("Wallace"));
        t.run();
        new Thread(new Messenger("Gromit")).start();
    }
}

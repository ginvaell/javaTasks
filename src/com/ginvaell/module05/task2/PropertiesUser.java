package com.ginvaell.module5.task2;

import java.io.IOException;

public class PropertiesUser implements Runnable {
    private static int count = 0;
    private final int n;
    final PropertiesBundle bundle;
    final String fname;

    public PropertiesUser(String fname, PropertiesBundle bundle) {
        this.fname = fname;
        this.bundle = bundle;
        count++;
        n = count;
    }

    @Override
    public void run() {
        for (int i = 1; i < 20; i++) {
            try {
                System.out.println("Thread " + n + " got " + bundle.getValue(fname, "" + (i % 5)));
            } catch (IOException | IllegalArgumentException e) {
                System.err.println("\nThread " + n + ": " + e.getMessage());
            }
        }
    }
}

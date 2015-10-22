package com.ginvaell.module7.task1;

import java.util.Map;
import java.util.Scanner;


public class TransHandler implements Runnable {
    private final Scanner in;
    private final Map<Integer, Account> accounts;
    private final int num;
    private int from;
    private int to;
    private int amount;

    public TransHandler(int num, Scanner in, Map<Integer, Account> accounts) {
        this.num = num;
        this.in = in;
        this.accounts = accounts;
    }

    private boolean read() {
        synchronized (in) {
            if (in.hasNextInt()) {
                from = in.nextInt();
            } else return false;
            if (in.hasNextInt()) {
                to = in.nextInt();
            } else return false;
            if (in.hasNextInt()) {
                amount = in.nextInt();
            } else return false;
        }
        return true;

    }

    private void withdraw() {
        synchronized (accounts.get(from)) {
            accounts.get(from).withdraw(amount);
            System.out.println("Handler " + num + " withdrew " + amount + " from " + from + "\n" + from + ": " + accounts.get(from).getBalance());
        }
    }

    private void deposit() {
        synchronized (accounts.get(to)) {
            accounts.get(to).deposit(amount);
            System.out.println("Handler " + num + " deposited " + amount + " to " + to + "\n" + to + ": " + accounts.get(to).getBalance());
        }
    }

    @Override
    public void run() {
        while (read()) {
            withdraw();
            deposit();
        }
    }
}

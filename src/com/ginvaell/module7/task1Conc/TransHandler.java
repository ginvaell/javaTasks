package com.ginvaell.module7.task1Conc;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransHandler implements Callable {
    private static Lock lock = new ReentrantLock();
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

    private boolean read()
    {
        try {
            lock.lock();
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
        finally {
            lock.unlock();
        }
        return true;

    }

    private void withdraw() {
            accounts.get(from).withdraw(amount);
            System.out.println("Handler "+num+" withdrew " + amount+ " from " +from+"\n"+from+": " + accounts.get(from).getBalance());
    }

    private void deposit() {
       // synchronized (accounts.get(to)) {
            accounts.get(to).deposit(amount);
            System.out.println("Handler "+num+" deposited "+ amount+" to " + to+"\n"+to+": " + accounts.get(to).getBalance());
       // }
    }

    @Override
    public Integer call() {
        while(read())
        {
            withdraw();
            deposit();
        }
        return 1;
    }
}

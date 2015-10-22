package com.ginvaell.module7.task1Conc;

import java.util.concurrent.atomic.AtomicInteger;


public class Account {
    private final AtomicInteger balance;

    public Account(int balance) {
        this.balance = new AtomicInteger(balance);
    }

    public int getBalance() {
        return balance.get();
    }

    public void deposit(int amount) {
        balance.addAndGet(amount);
    }

    public void withdraw(int amount) {
        balance.addAndGet(-1 * amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return getBalance() == account.getBalance();

    }

    @Override
    public int hashCode() {
        return getBalance();
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                "}\n";
    }
}

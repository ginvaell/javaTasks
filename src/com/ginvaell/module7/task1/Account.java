package com.ginvaell.module7.task1;

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {

        balance -= amount;
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

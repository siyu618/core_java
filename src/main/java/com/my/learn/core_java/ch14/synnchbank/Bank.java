package com.my.learn.core_java.ch14.synnchbank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tianzy on 3/25/14.
 */
public class Bank {
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();

    public Bank(double[] accounts) {
        this.accounts = accounts;
    }

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i ++) {
            accounts[i] = initialBalance;
        }
    }

    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        bankLock.lock();
        try {
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("  %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double item : accounts) {
            sum += item;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}

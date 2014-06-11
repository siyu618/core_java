package com.my.learn.core_java.ch14.synnchbank;

/**
 * Created by tianzy on 3/25/14.
 */
public class SyncchBankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INITAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i ++) {
            TransferRunnable r = new TransferRunnable(b, i, INITAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }

}

package com.my.learn.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by  on 14-12-5.
 */
public class LockTest {
    private static volatile Map<String, Object> map = new HashMap<String, Object>();
    private static final String UNIQUE_NAME = "123";
    static class AThread extends Thread {
        private Map map = null;

        public AThread(Map map) {
            this.map = map;
        }

        @Override
        // need the synchronized here
        public synchronized  void run() {
            System.out.println("A await");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                map.put(UNIQUE_NAME, Thread.currentThread());
                wait();
                System.out.println("Athread, released....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class BThread extends Thread {
        private Map map = null;

        public BThread(Map map) {
            this.map = map;
        }

        @Override
        public  void run() {
            Thread lock = (Thread) map.get(UNIQUE_NAME);
            System.out.println("notify Athread");
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AThread aThread = new AThread(map);
        BThread bThread = new BThread(map);
        aThread.start();
        Thread.sleep(1000 * 5);
        bThread.start();
        aThread.join();
        bThread.join();
        System.out.println("all done");
    }
}

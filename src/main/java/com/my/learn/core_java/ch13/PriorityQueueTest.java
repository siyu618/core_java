package com.my.learn.core_java.ch13;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * Created by tianzy on 3/19/14.
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<GregorianCalendar> priorityQueue = new PriorityQueue<GregorianCalendar>();
        priorityQueue.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9));
        priorityQueue.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10));
        priorityQueue.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3));
        priorityQueue.add(new GregorianCalendar(1910, Calendar.JUNE, 22));

        System.out.println("iterating items...");
        for (GregorianCalendar date : priorityQueue) {
            System.out.println(date.get(Calendar.YEAR));
        }
        System.out.println("Remove elements...");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove().get(Calendar.YEAR));
        }
    }
}

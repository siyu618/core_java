package com.my.learn.core_java.ch13;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by tianzy on 3/18/14.
 */
public class LinkedListTest {

    private void printList(List list) {
        for (Object object : list) {
            System.out.println(object);
        }
        System.out.println("==");
    }

    @Test
    public void testRemove() {
        List<String> list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator<String> iterator = list.iterator();
        iterator.next();
        iterator.next();
        printList(list);
        iterator.remove();
        printList(list);
       // iterator.remove();
        //printList(list);
    }

    @Test
    public void testListIteratorAdd() {
        List<String> list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        printList(list);
        ListIterator iterator = list.listIterator();
        iterator.add("1");
        printList(list);
        iterator.next();
        iterator.add("d");
        printList(list);
    }

    @Test
    public void testPrevious() {
        List<String> list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        printList(list);
        ListIterator iterator = list.listIterator();
        iterator.next();
        iterator.next();
        String pre = (String)iterator.previous();
        iterator.remove();
        System.out.println(pre);
        printList(list);
    }

    @Test
    public void testAll() {
        List<String> a = new LinkedList<String>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        //merge the words from b into a
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);
        System.out.println(b);

        // remove every second word from b
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);

        // bulk operation : remove all words in b from a
        a.removeAll(b);
        System.out.println(a);
    }
}

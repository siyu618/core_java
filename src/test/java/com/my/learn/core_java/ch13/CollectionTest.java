package com.my.learn.core_java.ch13;

import org.testng.annotations.Test;

import java.util.*;
import java.util.Collection;

/**
 * Created by tianzy on 3/17/14.
 */
public class CollectionTest {

    private void printAll(java.util.Collection collection) {
       // System.out.println("dump collection:" + collection);;
        for (Object obj : collection) {
            System.out.println(obj);
        }
    }

    @Test
    public void removeTest() {
        Collection<Integer> integers = new ArrayList();
        integers.add(1);
        integers.add(4);
        integers.add(6);

        printAll(integers);
        Iterator<Integer> iterator = integers.iterator();
        iterator.next();
        iterator.remove();
        //iterator.remove(); // error here, remove() depends on next()
        printAll(integers);
    }
}

package com.my.learn.core_java.ch13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tianzy on 3/23/14.
 */
public class ViewAndWappersTest {
    public static void main(String[] args) {
        Integer[] integers = {10, 9, 8, 7};
        List<Integer> list = Arrays.asList(integers);
        list.set(2, 10);
        //list.add(5, 100);

        System.out.println(list);

        List<Integer> integers1 = Collections.nCopies(3, 5);
        //integers1.add(6, 11);
        System.out.println(integers1);

    }
}

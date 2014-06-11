package com.my.learn.core_java.ch13;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tianzy on 3/19/14.
 */
public class LinkedHashMapTest {

    public  static void main(String[] args) {
        Map staff = new LinkedHashMap();
        staff.put("144-25-5464", "Amy");
        staff.put("567-24-2546", "Harry");
        staff.put("157-62-7935", "Gary");
        staff.put("456-62-5527", "Frank");
        for (Object obj : staff.keySet()) {
            System.out.println(obj);
        }

        for (Object obj: staff.values()) {
            System.out.println(obj);

        }
    }
}

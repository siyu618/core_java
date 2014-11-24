package com.yahoo.learn.core_java.ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesTest {

    public static void test() {
        List<Integer> list = new ArrayList<Integer>(1000);
        list.add(9);
        list.remove(9);
    }
    
    public static void showAllPropterties() {
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            System.out.println("key:[" + (String)key + "],value:[" + properties.getProperty((String) key) + "]");
        }
    }

    public static void main(String[] args) {
        showAllPropterties();
    }
}

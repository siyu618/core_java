package com.my.learn.core_java2.ch1;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

/**
 * Created by tianzy on 5/27/14.
 */
public class CharSetTest {
    public static void main(String[] args) {
        Map<String, Charset> map = Charset.availableCharsets();
        for (String name : map.keySet()) {
            System.out.println(name);
            Set<String> alias = map.get(name).aliases();
            for (String aliasItem : alias) {
                System.out.println("\t" + aliasItem);
            }
        }
    }
}

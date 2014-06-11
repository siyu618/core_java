package com.my.learn.core_java.ch5;

import java.util.Arrays;

import org.testng.annotations.Test;

public class ReflectionToStringTest {

    @Test
    public void test() {
        int[] iArr = {1,2,3,4,5,6};
        String[] sArr = {"a", "b", "c"};
        String[][] s2Arr = {{"a.1"}, {"b.2", "c.2"}, {"d.3", "e.3", "f.3"}};
        System.out.println(iArr);
        System.out.println(sArr);
        System.out.println(s2Arr);
        System.out.println(Arrays.toString(iArr));
        System.out.println(Arrays.toString(sArr));
        System.out.println(Arrays.deepToString(s2Arr));
    }

    public static double max(double... values) {
        // should check if the vaues is null
        double largest = Double.MIN_VALUE;
        for (double v : values) {if (largest < v) {largest = v;}}
        return largest;
    }
    @Test
    public void test2() {
        System.out.println(max(1, 2, 4, 5,6 ));
        System.out.println(max(new double[]{1, 2, 3, 4}));
        System.out.println(max());
    }
}

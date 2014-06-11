package com.my.learn.core_java.ch5;

import org.testng.annotations.Test;

public class ExceptionTest {

    @Test (expectedExceptions=ArithmeticException.class)
    public void test() {
        int i = 3 / 0;
        System.out.println(i);
    }
    
    @Test
    public void test2() {
        try {
            int i = 3 / 0;
            System.out.println(i);
        } catch (ArithmeticException e) {
            System.out.println("catch exception:");
            e.printStackTrace();
        }
    }

}

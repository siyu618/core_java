package com.my.learn.core_java.ch3;

public class StringLength {

    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(str.length());
        System.out.println(str.codePointCount(0, str.length()));
    }
}

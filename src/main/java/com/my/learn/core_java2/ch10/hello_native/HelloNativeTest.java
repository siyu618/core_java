package com.my.learn.core_java2.ch10.hello_native;

/**
 * Created by yidianadmin on 14-11-28.
 */
public class HelloNativeTest {
    static {
        System.out.println("load the library...");
        System.loadLibrary("HelloNative");
    }
    public static void main(String[] args) {
 String prop = System.getProperty("java.library.path");  
        System.out.println("java.library.path : " + prop);  
	    System.out.println("before");

        HelloNative.greeting();
	    System.out.println("after..");
    }
}


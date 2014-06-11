package com.my.learn.core_java.ch10;

/**
 * Created by tianzy on 3/12/14.
 */
public class WildcardCaptureTest {
    public static void swap(Pair<?> p) {
        //? t = p.getFirst();
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}

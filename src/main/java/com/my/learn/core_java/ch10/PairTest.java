package com.my.learn.core_java.ch10;

/**
 * Created by tianzy on 3/10/14.
 */
public class PairTest {

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "b", "a", "c"};
        Pair<String> minMax = ArraryAlg.getMinMax(arr);
        System.out.println("min:" + minMax.getFirst());
        System.out.println("max:" + minMax.getSecond());
        System.out.println("middle:" + ArraryAlg.getMiddle(arr));
        double middle = ArraryAlg.getMiddle(new Double[]{3.14, 1729.0, 0.0});
        System.out.println("middle:" +  middle);
        System.out.println("Min:" + ArraryAlg.getMinMax(arr).getFirst());
        System.out.println("Min:" + ArraryAlg.<String>getMinMax(arr).getFirst());
        System.out.println("Min:" + ArraryAlg.getMinMax(new Double[]{3.14, 1729.0, 0.0}).getFirst());

        Pair<String>[] table = new Pair[10];
        //table[0].setFirst("first");
       // table[0].setSecond("second");
        //System.out.println(table[0].getFirst());
        //Object[] objarray = table;
        //objarray[0] = new
        table[0] = new Pair<String>("first", "second");System.out.println(table[0].getFirst());
        //table[1] = new Pair<Integer>(2, 1);System.out.println(table[0].getFirst());
    }
}

class ArraryAlg {

    public static <T extends Comparable> Pair<T> getMinMax(T[] arr) {
        System.out.println("Comparble invoked.");
        if (null == arr || arr.length == 0) {
            return null;
        }
        T min = arr[0];
        T max = arr[1];
        for (int i = 1; i < arr.length; i ++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
            if (arr[i].compareTo(min) < 0) {
                min = arr[i];
            }
        }
        return new Pair(min, max);
    }

    public static Pair<String> getMinMax(String[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        String min = arr[0];
        String max = arr[1];
        for (int i = 1; i < arr.length; i ++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
            if (arr[i].compareTo(min) < 0) {
                min = arr[i];
            }
        }
        return new Pair(min, max);
    }

    public static  <T> T getMiddle(T[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        return arr[arr.length/2];
    }
}

package com.my.learn.core_java2.ch2;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yidianadmin on 14-10-29.
 */
@Getter
@Setter
public class Test {
    private String name;
    private boolean isGood;
    private boolean iSGood2;
    private boolean cold;


    public static void main(String[] args) {
        Test test = new Test();
        test.isGood();
        test.isCold();
        test.isISGood2();
    }
}

package com.my.learn.core_java.ch5;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReflectionPrintClassInfoTest {
    @DataProvider(name = "test2Provider")
    public Object[][] createData() {
        return new Object[][] {
                {"java.lang.Double"},
                {"com.my.learn.core_java.ch5.Manager"},
                {"java.util.Date"},
        };
    }

    @Test
    public void test() throws ClassNotFoundException {
        String clzName = "java.lang.Double";
        ReflectionPrintClassInfo.printClassInfo(clzName);
    }

    @Test(dataProvider="test2Provider")
    public void test2(String clzName) throws ClassNotFoundException {
        ReflectionPrintClassInfo.printClassInfo(clzName);
    }
}

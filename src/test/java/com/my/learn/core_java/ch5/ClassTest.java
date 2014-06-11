package com.my.learn.core_java.ch5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.Test;

public class ClassTest {

    @Test
    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String string = "";
        Class class1 = string.getClass();
        System.out.println(class1 + ":#" + class1.getName());
        String className = "java.util.Date";
        Class dateClass = Class.forName(className);
        Object object = dateClass.newInstance();
        System.out.println(object);
        Class class2 = Employee.class;
        Constructor constructor = class2.getConstructor(String.class, double.class, int.class, int.class, int.class);
        Object employee = constructor.newInstance("Jone", 120000, 2013, 12, 9);
        System.out.println("employee:" + employee);
    }

    @Test
    public void test2() {
        Class class1 = String.class;
        Class class2 = int.class;
        Class class3 = Double[].class;
        Class class4 = int[].class;
        System.out.println("test2");
        System.out.println(class1.getName());
        System.out.println(class2.getName());
        System.out.println(class3.getName());
        System.out.println(class4.getName());


    }
}

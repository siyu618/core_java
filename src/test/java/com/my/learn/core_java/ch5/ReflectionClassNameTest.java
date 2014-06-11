package com.my.learn.core_java.ch5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.testng.annotations.Test;

public class ReflectionClassNameTest {

    @Test
    public void className() {
        System.out.println(Double[].class.getName());
        System.out.println(int[].class.getName());
    }

    @Test
    public void testGetClass() {
        Date date = new Date();
        assert Date.class == date.getClass();
    }

    @Test
    public void testNewInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        String string = "java.util.Date";
        Object object = Class.forName(string).newInstance();
        assert object instanceof Date;
        assert object.getClass() == Date.class;
    }

    @Test
    public void testNewInstance2() throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String string = "java.util.Date";
        long dateLong = 13000000;
        Constructor<?> constructor = Class.forName(string).getConstructor(long.class);
        Object object = constructor.newInstance(dateLong);
        assert object instanceof Date;
        System.out.println(object);
    }


}

package com.my.learn.core_java.ch5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class ReflectionPrintClassInfo {

    public static void printClassInfo(String className)
            throws ClassNotFoundException {
        @SuppressWarnings("rawtypes")
        Class clz = Class.forName(className);
        Class superClz = clz.getSuperclass();
        String modifiers = Modifier.toString(clz.getModifiers());
        if (modifiers.length() > 0) {
            System.out.print(modifiers + " ");
        }
        System.out.print("class " + className);
        if (null != superClz && Object.class != superClz) {
            System.out.print(" extends " + superClz.getName());
        }
        System.out.println(" { ");
        printConstructorInfo(clz);
        printMethodInfo(clz);
        printFieldInfo(clz);
        System.out.println("}");
    }

    public static void printConstructorInfo(Class clz) {
        Constructor[] constructors = clz.getConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print("\t");
            String modifier = Modifier.toString(constructor.getModifiers());
            if (modifier.length() > 0) {
                System.out.print(modifier + " ");
            }
            System.out.print(name + "(");
            Class[] paramTypes = constructor.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(" ,");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethodInfo(Class clz) {
        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            System.out.print("\t");
            String modifier = Modifier.toString(method.getModifiers());
            if (modifier.length() > 0) {
                System.out.print(modifier + " ");
            }
            System.out.print(method.getReturnType().getName() + " " + name + "(");
            Class[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(" ,");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }

    }

    public static void printFieldInfo(Class clz) {
        Field[] fields = clz.getFields();
        for (Field field : fields) {
            Class type = field.getClass();
            String name = field.getName();
            System.out.print("\t");
            String modifier = Modifier.toString(field.getModifiers());
            if (modifier.length() > 0) {
                System.out.print(modifier + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }

    }

}

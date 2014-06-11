package com.my.learn.core_java.ch3;

import java.io.Console;
import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {
         @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
         System.out.println("What is your name?");
         String name = scanner.nextLine();
         System.out.println("How old are you?");
         int age = scanner.nextInt();

         System.out.println("Hello, " + name + ". Next year you will be " +
         (age + 1));

        Console console = System.console();
        if (null == console) {
            System.out.println("Console empty");
            console = System.console();
        } else {
            String userName = console.readLine("User name:");
            char[] passwd = console.readPassword("Password:");
            System.out.println("name:[" + userName + "], pwd[" + new String(passwd) + "]");
        }
    }

}

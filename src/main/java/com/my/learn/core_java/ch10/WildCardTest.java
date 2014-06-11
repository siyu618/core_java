package com.my.learn.core_java.ch10;


import com.my.learn.core_java.ch5.Employee;
import com.my.learn.core_java.ch5.Manager;

/**
 * Created by tianzy on 3/12/14.
 */
public class WildCardTest {
    public static void printBuddies(Pair<Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println("First:" + first + ", second:" + second);
    }

    public static void printBuddies2(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println("First:" + first + ", second:" + second);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("e1", 100.0, 1987, 06, 15);
        Employee e2 = new Employee("e2", 100.0, 1987, 06, 15);
        Manager m1 = new Manager("m1", 100.0, 1987, 06, 15);
        Manager m2 = new Manager("m2", 100.0, 1987, 06, 15);

        printBuddies(new Pair<Employee>(e1, e2));
        //printBuddies(new Pair<Manager>(m1, m2));

        printBuddies2(new Pair<Employee>(e1, e2));
        printBuddies2(new Pair<Manager>(m1, m2));

        Pair<Manager> managerPair = new Pair<Manager>(m1, m2);
        Pair<? extends  Employee> wildBuddeis = managerPair;
        //wildBuddeis.setFirst(e1);
        Employee employee = wildBuddeis.getFirst();
        //Manager manager = wildBuddeis.getFirst();
    }
}

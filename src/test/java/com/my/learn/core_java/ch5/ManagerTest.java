package com.my.learn.core_java.ch5;

import org.testng.annotations.Test;

public class ManagerTest {

    @Test
    public void test() {
        Manager manager = new Manager("Jone", 100000.0, 2013, 12, 1);
        System.out.println(manager.getSalary());
        manager.setBonus(90000);
        System.out.println(manager.getSalary());
        System.out.println(manager.getHireDay());
        Employee employee = manager;
        //employee.getBonus();
        System.out.println(employee.getSalary());
    }

    @Test
    public void test2() {
        Manager[] managers = new Manager[10];
        Employee[] employees = managers;
        //employees[0] = new Employee("Jons", 10000, 2013, 10, 5);
        //managers[0].setBonus(10.0);
        //System.out.println(managers[0].getSalary());
    }

    @Test
    public void testEquals() {
        Employee e1 = new Employee("Jone", 1000, 2012, 10, 19);
        Employee e2 = new Employee("Jone", 1000, 2012, 10, 19);
        assert e1.equals(e2);
        Manager manager1 = new Manager("Jone", 1000, 2012, 10, 19);
        Manager manager2 = new Manager("Jone", 1000, 2012, 10, 19);
        assert manager1.equals(manager2);
    }


}

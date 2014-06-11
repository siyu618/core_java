package com.my.learn.core_java.ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;


public class EmployeeTest {
    @Test
    public void testSort() {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("zhangsan", 10000));
        list.add(new Employee("lisi", 900000));
        list.add(new Employee("wangwu", 7000));
        Employee[] eArrayEmployees = (Employee[])list.toArray(new Employee[0]);
        System.out.println(Arrays.toString(eArrayEmployees));
        Arrays.sort(eArrayEmployees);
        System.out.println(Arrays.toString(eArrayEmployees));
    }

    @Test
    public void testClone() {
        Employee employee = new Employee("name", 1234);
    }



}

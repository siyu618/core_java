package com.my.learn.core_java.ch5;

import java.util.Date;
import java.util.GregorianCalendar;


public class Employee {
    private String name = null;
    private double salary = 0.0;
    private long hireDay = 0;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireDay = calendar.getTimeInMillis();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(hireDay);
        return calendar.getTime();
    }

    public void setHireDay(long hireDay) {
        this.hireDay = hireDay;
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (anotherObject == this) {
            return true;
        }
        if (null == anotherObject) {
            return false;
        }
        System.out.println("Employee.equals()#this:" + this.getClass());
        System.out
                .println("Employee.equals()#that:" + anotherObject.getClass());
        if (this.getClass() != anotherObject.getClass()) {
            return false;
        }
        Employee otherEmployee = (Employee) anotherObject;
        return name.equals(otherEmployee.name)
                && salary == otherEmployee.salary
                && hireDay == otherEmployee.hireDay;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(this.getClass().getName()).append("#").append("name=")
                .append(name).append(";hirDay=").append(hireDay)
                .append(";salary=").append(salary);
        return buffer.toString();
    }

}

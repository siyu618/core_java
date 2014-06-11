/**
 *
 */
package com.my.learn.core_java.ch6;

/**
 * @author tianzy
 *
 */
public class Employee implements Comparable<Employee> {

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    public int compareTo(Employee other) {
        if (this.salary < other.salary) {
            return -1;
        } else if (this.salary > other.salary) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "(name=" + name + ",salary=" + salary + ")";
    }

    private String name = null;
    private double salary = 0.0;


}

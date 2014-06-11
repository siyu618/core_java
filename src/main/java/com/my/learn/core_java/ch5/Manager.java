package com.my.learn.core_java.ch5;

public class Manager extends Employee{

    private double bonus = 0.0;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bonus = 0.0;
    }
   // @Override
    public double getSalary() {
        // return salary + bonus;// got compile error, for subclass could not access the private field in supper class.
        return super.getSalary() + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (!super.equals(anotherObject)) {
            return false;
        }
        Manager otherManager = (Manager)anotherObject;
        return bonus == otherManager.bonus;
    }
}

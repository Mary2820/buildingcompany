package com.solvd.buildingcompany.empoyees;

public abstract class Employee {
    String name;
    String lastName;
    int workExperience;
    int salary;

    public Employee(String name, String lastName, int workExperience, int salary) {
        this.name = name;
        this.lastName = lastName;
        this.workExperience = workExperience;
        this.salary = salary;
    }

    public void performDuties() {
        System.out.println(name + lastName + " is performing his duties");
    }
}

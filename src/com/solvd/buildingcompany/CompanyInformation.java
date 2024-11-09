package com.solvd.buildingcompany;

public class CompanyInformation {
    private String name;
    private int employeesNumber;
    private int phoneNumber;
    private String businessActivityType;

    public CompanyInformation(String name, int employeesNumber, int phoneNumber, String businessActivityType) {
        this.name = name;
        this.employeesNumber = employeesNumber;
        this.phoneNumber = phoneNumber;
        this.businessActivityType = businessActivityType;
    }

    public CompanyInformation() {
    }
}

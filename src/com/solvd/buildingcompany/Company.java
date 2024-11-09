package com.solvd.buildingcompany;

import com.solvd.buildingcompany.empoyees.Employee;

public class Company {
    private Employee[] employees;
    private Premises[] premises;
    private Project[] projects;
    private Customer[] customers;
    private CompanyInformation companyInformation;

    public Company(CompanyInformation companyInformation) {
        this.companyInformation = companyInformation;
    }

    public Company() {

    }
}

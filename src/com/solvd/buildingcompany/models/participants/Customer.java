package com.solvd.buildingcompany.models.participants;

import com.solvd.buildingcompany.models.Blueprint;
import com.solvd.buildingcompany.enums.BuildingType;
import com.solvd.buildingcompany.models.Project;

public class Customer {
    private String name;
    private String lastName;
    private String phoneNumber;

    public Customer(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Project planProject() {
        System.out.printf("Customer %s %s plans a project.\n", getName(), getLastName());
        return new Project(BuildingType.INDUSTRIAL_BUILDING, 856000,
                "Warsaw, Pilow Street, 145B");
    }

    public boolean isBlueprintApproved(Blueprint blueprint) {
        System.out.println("Customer approves the blueprint.");
        return blueprint != null;
    }
}
package com.solvd.buildingcompany.models.participants;

import com.solvd.buildingcompany.models.Blueprint;
import com.solvd.buildingcompany.enums.BuildingType;
import com.solvd.buildingcompany.models.Project;

import java.util.Objects;

public class Customer {
    private static final int MASK = 6;
    private String name;
    private String lastName;
    private String phoneNumber;

    public Customer(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (hashCode() != o.hashCode()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(lastName, customer.lastName) &&
                Objects.equals(phoneNumber, customer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return MASK + Objects.hashCode(name) + Objects.hashCode(lastName) + Objects.hashCode(phoneNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
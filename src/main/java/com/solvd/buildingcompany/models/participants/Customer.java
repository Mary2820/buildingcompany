package com.solvd.buildingcompany.models.participants;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.exceptions.BlueprintNotApprovedException;
import com.solvd.buildingcompany.models.Blueprint;
import com.solvd.buildingcompany.enums.BuildingType;
import com.solvd.buildingcompany.models.Budget;
import com.solvd.buildingcompany.models.Project;
import com.solvd.buildingcompany.utils.linkedlist.MyLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private static final Logger logger = LogManager.getLogger(Customer.class.getName());

    private static final int MASK = 6;
    private String name;
    private String lastName;
    private String phoneNumber;

    public Customer(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
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
        logger.info("Customer {} {} plans a project.\n", getName(), getLastName());

        ArrayList<BuildingStage> stages = new ArrayList<>();
        stages.add(BuildingStage.FOUNDATION);
        stages.add(BuildingStage.WALLS);
        stages.add(BuildingStage.ROOF);
        stages.add(BuildingStage.WINDOWS);
        stages.add(BuildingStage.DOORS);
        stages.add(BuildingStage.ELECTRICAL_SYSTEM);

        return new Project(BuildingType.INDUSTRIAL_BUILDING, new Budget(85000),
                "Warsaw, Pilow Street, 145B", 1800, new MyLinkedList<>(),
                stages);
    }

    public boolean isBlueprintApproved(Blueprint blueprint, int expectedAreaSize) throws BlueprintNotApprovedException {
        logger.info("Customer approves the blueprint.");
        if (blueprint.getActualAreaSize() != expectedAreaSize) {
            throw new BlueprintNotApprovedException("Blueprint is not approved because the area does not meet " +
                    "the customer's requirements");
        }
        return true;
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
package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.interfaces.IHandleEmergency;
import com.solvd.buildingcompany.models.building.Building;

public abstract class Employee implements IHandleEmergency {
    private int yearsOfExperience;
    private String name;
    private String lastName;
    private BuildingStage[] responsibilities;

    public Employee(String name, String lastName, int yearsOfExperience) {
        this.name = name;
        this.lastName = lastName;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Employee() {}

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

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public BuildingStage[] getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(BuildingStage[] responsibilities) {
        this.responsibilities = responsibilities;
    }

    public abstract void createPlan();

    public abstract void prepareToWork();

    public abstract void work(Building building, BuildingStage buildingStage);

    public abstract void submitReport();

    public abstract void maintainEquipment();

}
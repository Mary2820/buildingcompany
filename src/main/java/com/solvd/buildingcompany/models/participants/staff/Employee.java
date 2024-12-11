package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.enums.ProficiencyLevel;
import com.solvd.buildingcompany.interfaces.IHandleEmergency;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.utils.linkedlist.MyLinkedList;

public abstract class Employee implements IHandleEmergency {
    private int yearsOfExperience;
    private String name;
    private String lastName;
    private BuildingStage[] responsibilities;
    private ProficiencyLevel proficiencyLevel;
    private double salary;


    public Employee(String name, String lastName, int yearsOfExperience, ProficiencyLevel level, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.yearsOfExperience = yearsOfExperience;
        this.proficiencyLevel = level;
        this.salary = salary;
    }

    public Employee() {
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

    public ProficiencyLevel getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(ProficiencyLevel proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void createPlan();

    public abstract void prepareToWork();

    public abstract void work(Building building, BuildingStage buildingStage);

    public abstract void addReport(MyLinkedList<String> reports);

    public abstract void maintainEquipment();
}
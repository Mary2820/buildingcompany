package com.solvd.buildingcompany.models;

import com.solvd.buildingcompany.enums.BuildingType;
import com.solvd.buildingcompany.interfaces.IManageSchedule;
import com.solvd.buildingcompany.models.participants.staff.Employee;

import java.time.LocalDate;

public class Project implements IManageSchedule {
    private boolean isCompleted;
    private double budget;
    private String address;
    private BuildingType buildingType;
    private Blueprint blueprint;
    private Employee[] team;
    private LocalDate deadlineDate;

    public Project(BuildingType buildingType, double budget, String address) {
        this.buildingType = buildingType;
        this.budget = budget;
        this.address = address;
    }

    public Project(){}

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Blueprint getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(Blueprint blueprint) {
        System.out.println("Blueprint is added to the project.");
        this.blueprint = blueprint;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Employee[] getTeam() {
        return team;
    }

    public void setTeam(Employee[] team) {
        this.team = team;
    }

    @Override
    public void setDeadlineDate(LocalDate date) {
        this.deadlineDate = date;
        System.out.println("Schedule for the project set to: " + date);
    }

    @Override
    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }
}
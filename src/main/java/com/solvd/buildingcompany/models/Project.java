package com.solvd.buildingcompany.models;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.enums.BuildingType;
import com.solvd.buildingcompany.interfaces.IManageSchedule;
import com.solvd.buildingcompany.models.participants.staff.Employee;
import com.solvd.buildingcompany.utils.linkedlist.MyLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

public class Project implements IManageSchedule {
    private static final Logger logger = LogManager.getLogger(Project.class.getName());

    private Budget budget;
    private boolean isCompleted;
    private String address;
    private int expectedAreaSize;
    private BuildingType buildingType;
    private Blueprint blueprint;
    private Employee[] team;
    private List<BuildingStage> stages;
    private LocalDate deadlineDate;
    private MyLinkedList<String> reports;

    public Project(BuildingType buildingType, Budget budget, String address, int expectedAreaSize,
                   MyLinkedList<String> reports, List<BuildingStage> stages) {
        this.buildingType = buildingType;
        this.budget = budget;
        this.address = address;
        this.expectedAreaSize = expectedAreaSize;
        this.reports = reports;
        this.stages = stages;
    }

    public Project(){}

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getExpectedAreaSize() {
        return expectedAreaSize;
    }

    public void setExpectedAreaSize(int expectedAreaSize) {
        this.expectedAreaSize = expectedAreaSize;
    }

    public Blueprint getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(Blueprint blueprint) {
        logger.info("Blueprint is added to the project.");
        this.blueprint = blueprint;
    }

    public boolean isCompleted() {
        if (isCompleted) {
            logger.info("is completed");
        } else {
            logger.info("in progress");
        }
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

    public List<BuildingStage> getStages() {
        return stages;
    }

    public void setStages(List<BuildingStage> stages) {
        this.stages = stages;
    }

    @Override
    public void setDeadlineDate(LocalDate date) {
        this.deadlineDate = date;
        logger.info("Schedule for the project set to: {}", date);
    }

    @Override
    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }

    public MyLinkedList<String> getReports() {
        return reports;
    }

    public void setReports(MyLinkedList<String> reports) {
        this.reports = reports;
    }

    public void increaseMaterialExpenses(double value) {
        double materialExpenses = budget.getMaterialExpenses();
        budget.setMaterialExpenses(materialExpenses + value);
    }
}
package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.models.Blueprint;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.utils.MyLinkedList;

public class Architect extends Employee{
    private int salary;

    public Architect(String name, String lastName, int yearsOfExperience, int salary) {
        super(name, lastName, yearsOfExperience);
        this.salary = salary;
    }

    public Architect() {super();}

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Blueprint createBlueprint() {
        System.out.printf("Architect %s %s creates a blueprint.\n", getName(), getLastName());
        return new Blueprint(4, 1800, 100, 250,
                120);
    }

    @Override
    public void createPlan() {
        System.out.println("Architect outlines the design stages, materials, and technical requirements..");
    }

    @Override
    public void prepareToWork() {
        System.out.println("Architect assembles blueprints, permits, and resources needed for the build");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        System.out.println("Architect ensures each phase aligns with architectural design and standards.");
    }

    @Override
    public void addReport(MyLinkedList<String> reports) {
        System.out.println("Architect documents construction milestones, design adjustments, and compliance updates..");
    }

    @Override
    public void maintainEquipment() {
        System.out.println("Architect keeps architectural tools and equipment calibrated and ready for use.");
    }

    @Override
    public void ReportIncident(String incidentDetails) {
        System.out.println("Architect reports an incident: " + incidentDetails);
    }

    @Override
    public void ExecuteEmergencyProtocol() {
        System.out.println("Architect tells company about incident and calls 911");
    }

    @Override
    public String AssessDamage() {
        System.out.println("Architect is assessing damage.");
        return "Damage assessment completed.";
    }
}
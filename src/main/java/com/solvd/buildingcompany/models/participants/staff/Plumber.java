package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.components.PlumbingSystem;
import com.solvd.buildingcompany.utils.MyLinkedList;

import java.util.Objects;

public class Plumber extends Employee{
    private static final int MASK = 5;
    private String serviceArea;

    public Plumber(String name, String lastName, int yearsOfExperience, BuildingStage[] responsibilities) {
        super(name, lastName, yearsOfExperience);

        setResponsibilities(responsibilities);
    }

    public Plumber() {super();}

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    @Override
    public void createPlan() {
        System.out.println("Plumber examines blueprints to understand the layout of pipes, fixtures, and drainage systems.");
    }

    @Override
    public void prepareToWork() {
        System.out.println("Plumber assembles necessary tools, materials, and ensures the area is safe and accessible" +
                " for plumbing work. ");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        System.out.printf("Plumber %s %s installs the plumbing system.\n", getName(), getLastName());
        building.setPlumbingSystem(new PlumbingSystem("central", "central"));
    }

    @Override
    public void addReport(MyLinkedList<String> reports) {
        reports.add("Plumber completed his work.");
        System.out.println("Plumber checks for leaks, ensures proper water flow, and verifies that all connections" +
                " are secure and functioning correctly.");
    }

    @Override
    public void maintainEquipment() {
        System.out.println("Plumber inspects and maintains tools to ensure they are in good working order for accurate" +
                " and safe use.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (hashCode() != o.hashCode()) return false;
        Plumber plumber = (Plumber) o;
        return Objects.equals(getServiceArea(), plumber.getServiceArea());
    }

    @Override
    public int hashCode() {
        return MASK + super.hashCode() + Objects.hashCode(serviceArea);
    }

    @Override
    public String toString() {
        return "Plumber{" + "name=" + getName() + ", lastName=" + getLastName() + '}';
    }

    @Override
    public void ReportIncident(String incidentDetails) {
        System.out.println("Plumber reports an incident: " + incidentDetails);
    }

    @Override
    public void ExecuteEmergencyProtocol() {
        System.out.println("Plumber leaves the construction site and notifies the construction engineer of the incident.");
    }

    @Override
    public String AssessDamage() {
        System.out.println("Plumber is assessing damage.");
        return "Damage assessment completed.";
    }
}
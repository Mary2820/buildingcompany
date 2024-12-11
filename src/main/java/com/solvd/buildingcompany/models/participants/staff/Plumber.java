package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.enums.ProficiencyLevel;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.components.PlumbingSystem;
import com.solvd.buildingcompany.utils.linkedlist.MyLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Plumber extends Employee{
    private static final Logger logger = LogManager.getLogger(Plumber.class.getName());

    private static final int MASK = 5;
    private String serviceArea;

    public Plumber(String name, String lastName, int yearsOfExperience, BuildingStage[] responsibilities,
                   ProficiencyLevel proficiencyLevel, double salary) {
        super(name, lastName, yearsOfExperience, proficiencyLevel, salary);

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
        logger.info("Plumber examines blueprints to understand the layout of pipes, fixtures, and drainage systems.");
    }

    @Override
    public void prepareToWork() {
        logger.info("Plumber assembles necessary tools, materials, and ensures the area is safe and accessible" +
                " for plumbing work. ");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        logger.info("Plumber {} {} installs the plumbing system.\n", getName(), getLastName());
        building.setPlumbingSystem(new PlumbingSystem("central", "central"));

        building.getProject().increaseMaterialExpenses(7000);
    }

    @Override
    public void addReport(MyLinkedList<String> reports) {
        reports.add("Plumber completed his work.");
        logger.info("Plumber checks for leaks, ensures proper water flow, and verifies that all connections" +
                " are secure and functioning correctly.");
    }

    @Override
    public void maintainEquipment() {
        logger.info("Plumber inspects and maintains tools to ensure they are in good working order for accurate" +
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
        logger.info("Plumber reports an incident: {}", incidentDetails);
    }

    @Override
    public void ExecuteEmergencyProtocol() {
        logger.info("Plumber leaves the construction site and notifies the construction engineer of the incident.");
    }

    @Override
    public String AssessDamage() {
        logger.info("Plumber is assessing damage.");
        return "Damage assessment completed.";
    }
}
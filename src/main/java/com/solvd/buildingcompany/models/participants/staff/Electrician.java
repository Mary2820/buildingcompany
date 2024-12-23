package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.demos.multithreading.OutletsInstaller;
import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.enums.ProficiencyLevel;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.components.ElectricalSystem;
import com.solvd.buildingcompany.models.building.components.Outlet;
import com.solvd.buildingcompany.utils.linkedlist.MyLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Electrician extends Employee{
    private static final Logger logger = LogManager.getLogger(Electrician.class.getName());

    private static final int MASK = 3;
    private boolean hasSafetyCertificate;

    public Electrician(String name, String lastName, int yearsOfExperience, BuildingStage[] responsibilities,
                       ProficiencyLevel proficiencyLevel, double salary) {
        super(name, lastName, yearsOfExperience, proficiencyLevel, salary);

        setResponsibilities(responsibilities);
    }

    public Electrician() {super();}

    public boolean hasSafetyCertificate() {
        return hasSafetyCertificate;
    }

    public void setHasSafetyCertificate(boolean hasSafetyCertificate) {
        this.hasSafetyCertificate = hasSafetyCertificate;
    }

    @Override
    public void createPlan() {
        logger.info("Electician studies wiring diagrams and blueprints to understand layout and requirements" +
                " for electrical systems.");
    }

    @Override
    public void prepareToWork() {
        logger.info("Electician gathers necessary tools, materials, and ensures the site is safe, verifying" +
                " that circuits are properly grounded.");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        logger.info("Electician {} {} installs the electrical system.\n", getName(), getLastName());

        List<Outlet> outlets = new ArrayList<>();

        int outletsCount = building.getProject().getBlueprint().getOutletsCount();

        for (int i = 0; i < outletsCount; i++) {
            outlets.add(new Outlet());
        }

        building.setElectricalSystem(new ElectricalSystem("220V", outlets));

        OutletsInstaller outletsInstaller = new OutletsInstaller();
        ElectricalSystem electricalSystem = building.getElectricalSystem();
        outletsInstaller.install(electricalSystem.getOutlets());

        building.getProject().increaseMaterialExpenses(15000);
    }

    @Override
    public void addReport(MyLinkedList<String> reports) {
        reports.add("Electrician completed his work.");
        logger.info("Electician conducts tests to ensure all connections are secure, circuits are functioning" +
                " correctly, and there are no hazards. ");
    }

    @Override
    public void maintainEquipment() {
        logger.info("Electician inspects and services tools, ensuring they are in safe working condition and" +
                " ready for future projects.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (hashCode() != o.hashCode()) return false;
        Electrician electrician = (Electrician) o;
        return Objects.equals(hasSafetyCertificate(), electrician.hasSafetyCertificate());
    }

    @Override
    public int hashCode() {
        return MASK + super.hashCode() + Objects.hashCode(hasSafetyCertificate);
    }

    @Override
    public String toString() {
        return "Electrician{" + "name=" + getName() + ", lastName=" + getLastName() + '}';
    }

    @Override
    public void ReportIncident(String incidentDetails) {
        logger.info("Electrician reports an incident: {}", incidentDetails);
    }

    @Override
    public void ExecuteEmergencyProtocol() {
        logger.info("Electrician leaves the construction site and notifies the construction engineer of the incident.");
    }

    @Override
    public String AssessDamage() {
        logger.info("Electrician is assessing damage.");
        return "Damage assessment completed.";
    }
}
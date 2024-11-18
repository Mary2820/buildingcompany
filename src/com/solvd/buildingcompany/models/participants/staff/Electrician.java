package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.components.ElectricalSystem;

import java.util.Objects;

public class Electrician extends Employee{
    private static final int MASK = 3;
    private boolean hasSafetyCertificate;

    public Electrician(String name, String lastName, int yearsOfExperience, BuildingStage[] responsibilities) {
        super(name, lastName, yearsOfExperience);

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
        System.out.println("Electician studies wiring diagrams and blueprints to understand layout and requirements" +
                " for electrical systems.");
    }

    @Override
    public void prepareToWork() {
        System.out.println("Electician gathers necessary tools, materials, and ensures the site is safe, verifying" +
                " that circuits are properly grounded.");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        System.out.printf("Electician %s %s installs the electrical system.\n", getName(), getLastName());
        building.setElectricalSystem(new ElectricalSystem("220V", 500));
    }

    @Override
    public void submitReport() {
        System.out.println("Electician conducts tests to ensure all connections are secure, circuits are functioning" +
                " correctly, and there are no hazards. ");
    }

    @Override
    public void maintainEquipment() {
        System.out.println("Electician inspects and services tools, ensuring they are in safe working condition and" +
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
        System.out.println("Electrician reports an incident: " + incidentDetails);
    }

    @Override
    public void ExecuteEmergencyProtocol() {
        System.out.println("Electrician leaves the construction site and notifies the construction engineer of the incident.");
    }

    @Override
    public String AssessDamage() {
        System.out.println("Electrician is assessing damage.");
        return "Damage assessment completed.";
    }
}
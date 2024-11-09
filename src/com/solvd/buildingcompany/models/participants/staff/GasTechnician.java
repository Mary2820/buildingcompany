package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.components.GasSystem;

import java.util.Objects;

public class GasTechnician extends Employee{
    public static final int MASK = 4;
    private boolean hasSafetyCertificate;

    public GasTechnician(String name, String lastName, int yearsOfExperience, BuildingStage[] responsibilities) {
        super(name, lastName, yearsOfExperience);

        setResponsibilities(responsibilities);
    }

    public boolean hasSafetyCertificate() {
        return hasSafetyCertificate;
    }

    public void setHasSafetyCertificate(boolean hasSafetyCertificate) {
        this.hasSafetyCertificate = hasSafetyCertificate;
    }

    @Override
    public void createPlan() {
        System.out.println("GasTechnician studies blueprints and specifications to understand the layout and" +
                " requirements of gas piping and appliances.");
    }

    @Override
    public void prepareToWork() {
        System.out.println("GasTechnician ensures the area is safe, checks for existing gas lines, and gathers" +
                " necessary tools and equipment for installation or repair. ");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        System.out.printf("GasTechnician %s %s installs the gas system.\n", getName(), getLastName() );
        building.setGasSystem(new GasSystem("Propane"));
    }

    @Override
    public void submitReport() {
        System.out.println("GasTechnician uses specialized equipment to check for gas leaks, pressure stability," +
                " and ensures that all installations are safe and functional. ");
    }

    @Override
    public void maintainEquipment() {
        System.out.println("GasTechnician inspects and calibrates tools, ensuring they are safe, reliable," +
                " and ready for future use. ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GasTechnician gasTechnician = (GasTechnician) o;
        return Objects.equals(hasSafetyCertificate(), gasTechnician.hasSafetyCertificate());
    }

    @Override
    public int hashCode() {
        return MASK + super.hashCode() + Objects.hashCode(hasSafetyCertificate);
    }

    @Override
    public String toString() {
        return "GasTechnician{" + "name=" + getName() + ", lastName=" + getLastName() + '}';
    }
}
package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.models.Blueprint;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.components.*;

import java.util.ArrayList;
import java.util.Objects;

public class DoorInstaller extends Employee{
    public static final int MASK = 2;
    private boolean hasCompletedTraining;

    public DoorInstaller(String name, String lastName, int yearsOfExperience, BuildingStage[] responsibilities) {
        super(name, lastName, yearsOfExperience);

        setResponsibilities(responsibilities);
    }

    public boolean hasCompletedTraining() {
        return hasCompletedTraining;
    }

    public void setHasCompletedTraining(boolean hasCompletedTraining) {
        this.hasCompletedTraining = hasCompletedTraining;
    }

    @Override
    public void createPlan() {
        System.out.println("DoorInstaller studies blueprints and measurements to understand the specifications for" +
                " each door and window. ");
    }

    @Override
    public void prepareToWork() {
        System.out.println("DoorInstaller ensures openings are level, clean, and ready for fitting, making necessary" +
                " adjustments for proper alignment.");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        Blueprint blueprint = building.getProject().getBlueprint();
        switch (buildingStage) {
            case WINDOWS:
                System.out.printf("Installer %s %s installs windows.\n", getName(), getLastName());
                installWindows(building, blueprint.getWindowsCount());
                break;
            case DOORS:
                System.out.printf("Installer %s %s installs doors.\n", getName(), getLastName());
                installDoors(building, blueprint.getDoorsCount());
                break;
        }
    }

    @Override
    public void submitReport() {
        System.out.println("DoorInstaller checks each installation for airtight seals, insulation, and quality" +
                " to ensure durability and energy efficiency.");
    }

    @Override
    public void maintainEquipment() {
        System.out.println("DoorInstaller Keeps installation tools in top condition, performing regular checks and" +
                " maintenance for accuracy and safety.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoorInstaller doorInstaller = (DoorInstaller) o;
        return Objects.equals(hasCompletedTraining, doorInstaller.hasCompletedTraining() );
    }

    @Override
    public int hashCode() {
        return MASK + super.hashCode() + Objects.hashCode(hasCompletedTraining);
    }

    @Override
    public String toString() {
        return "DoorInstaller{" + "name=" + getName() + ", lastName=" + getLastName() + '}';
    }

    private void installWindows(Building building, int windowsCount) {
        ArrayList<Window> windows = new ArrayList<>();
        for (int i = 0; i <= windowsCount; i++) {
            windows.add(new Window(1.5, 1.2, 0.05, "double-pane glass"));
        }
        building.setWindows(windows);
    }

    private void installDoors(Building building, int doorsCount) {
        ArrayList<Door> doors = new ArrayList<>();
        for (int i = 0; i <= doorsCount; i++) {
            doors.add(new Door(0.9, 2, true));
        }
        building.setDoors(doors);
    }
}
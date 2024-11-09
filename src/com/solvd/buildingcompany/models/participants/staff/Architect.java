package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.models.Blueprint;
import com.solvd.buildingcompany.models.building.Building;

public class Architect extends Employee{
    private boolean isAvailable;

    public Architect(String name, String lastName, int yearsOfExperience, boolean isAvailable, boolean isManagement) {
        super(name, lastName, yearsOfExperience);
        this.isAvailable = isAvailable;
        this.isManagement = isManagement;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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
    public void submitReport() {
        System.out.println("Architect documents construction milestones, design adjustments, and compliance updates..");
    }

    @Override
    public void maintainEquipment() {
        System.out.println("Architect keeps architectural tools and equipment calibrated and ready for use.");
    }
}

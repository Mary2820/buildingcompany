package com.solvd.buildingcompany.enums;

import java.util.Arrays;
import java.util.List;

public enum BuildingStage {
    FOUNDATION("Foundation stage", 1, 15),
    WALLS("Walls construction", 2, 60),
    ROOF("Roofing", 3, 30),
    WINDOWS("Windows installation", 4, 5),
    DOORS("Doors installation", 5, 5),
    PLUMBING_SYSTEM("Plumbing system installation", 6, 30),
    GAS_SYSTEM("Gas system installation", 7, 10),
    ELECTRICAL_SYSTEM("Electrical system installation", 8, 40);

    private final String description;
    private final int stageNumber;
    private final int durationInDays;

    BuildingStage(String description, int stageNumber, int durationInDays) {
        this.description = description;
        this.stageNumber = stageNumber;
        this.durationInDays = durationInDays;
    }

    public String getDescription() {
        return description;
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public static List<BuildingStage> getAllStages() {
        return Arrays.asList(BuildingStage.values());
    }
}
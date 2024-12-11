package com.solvd.buildingcompany.enums;

public enum InspectionCase {
    STRUCTURAL("Structural inspection"),
    ELECTRICAL("Electrical system inspection"),
    PLUMBING("Plumbing system inspection"),
    GAS("Gas system inspection"),
    FINAL("Final inspection");

    private final String description;

    InspectionCase(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

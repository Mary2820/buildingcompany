package com.solvd.buildingcompany.enums;

public enum ConstructionRiskLevel {
    LOW("Low risk", "Standard precautions"),
    MEDIUM("Medium risk", "Requires additional safety measures"),
    HIGH("High risk", "Strict safety protocols required"),
    CRITICAL("Critical risk", "Only with expert supervision");

    private final String levelName;
    private final String safetyProtocol;

    ConstructionRiskLevel(String levelName, String safetyProtocol) {
        this.levelName = levelName;
        this.safetyProtocol = safetyProtocol;
    }

    public String getLevelName() {
        return levelName;
    }

    public String getSafetyProtocol() {
        return safetyProtocol;
    }
}

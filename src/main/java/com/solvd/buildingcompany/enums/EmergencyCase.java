package com.solvd.buildingcompany.enums;

public enum EmergencyCase {
    FIRE("Fire emergency", "Call fire department immediately"),
    GAS_LEAK("Gas leak", "Shut off main gas valve and evacuate"),
    WATER_LEAK("Water leak", "Turn off water supply"),
    ELECTRICAL_OUTAGE("Electrical outage", "Contact an electrician"),
    STRUCTURAL_DAMAGE("Structural damage", "Contact an engineer");

    private final String description;
    private final String actionPlan;

    EmergencyCase(String description, String actionPlan) {
        this.description = description;
        this.actionPlan = actionPlan;
    }

    public String getDescription() {
        return description;
    }

    public String getActionPlan() {
        return actionPlan;
    }
}

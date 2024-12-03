package com.solvd.buildingcompany.models.building.components;

import com.solvd.buildingcompany.interfaces.IPerformMaintenance;

public class ElectricalSystem implements IPerformMaintenance {
    private String maxVoltage;
    private int outletsCount;
    private boolean isMaintenanceRequired;

    public ElectricalSystem(String maxVoltage, int outletsCount) {
        this.maxVoltage = maxVoltage;
        this.outletsCount = outletsCount;
    }

    public ElectricalSystem() {}

    public String getMaxVoltage() {
        return maxVoltage;
    }

    public void setMaxVoltage(String maxVoltage) {
        this.maxVoltage = maxVoltage;
    }

    public int getOutletsCount() {
        return outletsCount;
    }

    public void setOutletsCount(int outletsCount) {
        this.outletsCount = outletsCount;
    }

    public void setMaintenanceRequired(boolean isMaintenanceRequired) {
        this.isMaintenanceRequired = isMaintenanceRequired;
    }

    @Override
    public void performMaintenance() {
        if (isMaintenanceRequired) {
            System.out.println("Performing maintenance on the electrical system.");
            isMaintenanceRequired = false;
        } else {
            System.out.println("No maintenance required.");
        }
    }

    @Override
    public boolean isMaintenanceRequired() {
        return isMaintenanceRequired;
    }
}

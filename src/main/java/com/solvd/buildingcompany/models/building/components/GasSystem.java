package com.solvd.buildingcompany.models.building.components;

import com.solvd.buildingcompany.interfaces.IPerformMaintenance;

public class GasSystem implements IPerformMaintenance {
    private String gasType;
    private boolean isMaintenanceRequired;

    public GasSystem(String gasType) {
        this.gasType = gasType;
    }

    public GasSystem() {}

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType;
    }

    public void setMaintenanceRequired(boolean isMaintenanceRequired) {
        this.isMaintenanceRequired = isMaintenanceRequired;
    }

    @Override
    public void performMaintenance() {
        if (isMaintenanceRequired) {
            System.out.println("Performing maintenance on the gas system.");
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

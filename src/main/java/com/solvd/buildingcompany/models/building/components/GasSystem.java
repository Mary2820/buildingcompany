package com.solvd.buildingcompany.models.building.components;

import com.solvd.buildingcompany.interfaces.IPerformMaintenance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GasSystem implements IPerformMaintenance {
    private static final Logger logger = LogManager.getLogger(GasSystem.class.getName());

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
            logger.info("Performing maintenance on the gas system.");
            isMaintenanceRequired = false;
        } else {
            logger.info("No maintenance required.");
        }
    }

    @Override
    public boolean isMaintenanceRequired() {
        return isMaintenanceRequired;
    }
}

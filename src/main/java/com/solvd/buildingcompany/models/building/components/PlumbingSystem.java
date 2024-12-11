package com.solvd.buildingcompany.models.building.components;

import com.solvd.buildingcompany.interfaces.IPerformMaintenance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlumbingSystem implements IPerformMaintenance {
    private static final Logger logger = LogManager.getLogger(PlumbingSystem.class.getName());

    private String waterSupplyType;
    private String sewageType;
    private boolean isMaintenanceRequired;

    public PlumbingSystem(String waterSupplyType, String sewageType) {
        this.waterSupplyType = waterSupplyType;
        this.sewageType = sewageType;
    }

    public PlumbingSystem() {}

    public String getWaterSupplyType() {
        return waterSupplyType;
    }

    public void setWaterSupplyType(String waterSupplyType) {
        this.waterSupplyType = waterSupplyType;
    }

    public String getSewageType() {
        return sewageType;
    }

    public void setSewageType(String sewageType) {
        this.sewageType = sewageType;
    }

    public void setMaintenanceRequired(boolean isMaintenanceRequired) {
        this.isMaintenanceRequired = isMaintenanceRequired;
    }

    @Override
    public void performMaintenance() {
        if (isMaintenanceRequired) {
            logger.info("Performing maintenance on the plumbing system.");
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

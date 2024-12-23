package com.solvd.buildingcompany.models.building.components;

import com.solvd.buildingcompany.interfaces.IPerformMaintenance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ElectricalSystem implements IPerformMaintenance {
    private static final Logger logger = LogManager.getLogger(ElectricalSystem.class.getName());

    private String maxVoltage;
    private List<Outlet> outlets;
    private boolean isMaintenanceRequired;

    public ElectricalSystem(String maxVoltage, List<Outlet> outlets) {
        this.maxVoltage = maxVoltage;
        this.outlets = outlets;
    }

    public ElectricalSystem() {}

    public String getMaxVoltage() {
        return maxVoltage;
    }

    public void setMaxVoltage(String maxVoltage) {
        this.maxVoltage = maxVoltage;
    }

    public List<Outlet> getOutlets() {
        return outlets;
    }

    public void setOutlets(List<Outlet> outlets) {
        this.outlets = outlets;
    }

    public void setMaintenanceRequired(boolean isMaintenanceRequired) {
        this.isMaintenanceRequired = isMaintenanceRequired;
    }

    @Override
    public void performMaintenance() {
        if (isMaintenanceRequired) {
            logger.info("Performing maintenance on the electrical system.");
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

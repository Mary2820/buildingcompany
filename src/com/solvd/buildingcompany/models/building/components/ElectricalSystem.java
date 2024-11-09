package com.solvd.buildingcompany.models.building.components;

public class ElectricalSystem {
    private String maxVoltage;
    private int outletsCount;

    public ElectricalSystem(String maxVoltage, int outletsCount) {
        this.maxVoltage = maxVoltage;
        this.outletsCount = outletsCount;
    }

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
}

package com.solvd.buildingcompany.models.building.components;

public class PlumbingSystem {
    private String waterSupplyType;
    private String sewageType;

    public PlumbingSystem(String waterSupplyType, String sewageType) {
        this.waterSupplyType = waterSupplyType;
        this.sewageType = sewageType;
    }

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
}

package com.solvd.buildingcompany.models.building.components;

public class GasSystem {
    private String gasType;

    public GasSystem(String gasType) {
        this.gasType = gasType;
    }

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType;
    }
}

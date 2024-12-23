package com.solvd.buildingcompany.models.building.components;

public class Outlet {
    private String color;
    private int maxVoltage;
    private boolean isInstalled;

    public Outlet(String color, int maxVoltage) {
        this.color = color;
        this.maxVoltage = maxVoltage;
    }

    public Outlet(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxVoltage() {
        return maxVoltage;
    }

    public void setMaxVoltage(int maxVoltage) {
        this.maxVoltage = maxVoltage;
    }

    public boolean isInstalled() {
        return isInstalled;
    }

    public void setInstalled(boolean installed) {
        isInstalled = installed;
    }
}

package com.solvd.buildingcompany.models.building.components;

public class Door {
    private double width;
    private double height;
    private boolean hasLock;

    public Door(double width, double height, boolean hasLock) {
        this.width = width;
        this.height = height;
        this.hasLock = hasLock;
    }

    public Door() {}

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isHasLock() {
        return hasLock;
    }

    public void setHasLock(boolean hasLock) {
        this.hasLock = hasLock;
    }
}

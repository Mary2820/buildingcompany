package com.solvd.buildingcompany.models.building.components;

public class Wall {
    private int width;
    private int height;
    private double thickness;

    public Wall(int width, int height, double thickness) {
        this.width = width;
        this.height = height;
        this.thickness = thickness;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
}

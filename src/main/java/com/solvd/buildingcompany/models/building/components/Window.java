package com.solvd.buildingcompany.models.building.components;

public class Window {
    private double length;
    private double width;
    private double height;
    private String glassType;

    public Window(double length, double width, double height, String glassType) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.glassType = glassType;
    }

    public Window() {}

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

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

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }
}

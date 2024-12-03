package com.solvd.buildingcompany.models.building.components;

public class Foundation {
    private double area;
    private String material;

    public Foundation(double area, String material) {
        this.area = area;
        this.material = material;
    }

    public Foundation() {}

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}

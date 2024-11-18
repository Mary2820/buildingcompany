package com.solvd.buildingcompany.models.building.components;

public class Roof {
    private String roofType;
    private String material;
    private int area;

    public Roof(String roofType, String material, int area) {
        this.roofType = roofType;
        this.material = material;
        this.area = area;
    }

    public Roof() {}

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}

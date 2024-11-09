package com.solvd.buildingcompany;

public class Project {
    private BuildingType buildingType;
    private int budget;
    private String address;

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Project(BuildingType buildingType, int budget, String address) {
        this.buildingType = buildingType;
        this.budget = budget;
        this.address = address;
    }
}

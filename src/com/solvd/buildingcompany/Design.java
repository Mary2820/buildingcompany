package com.solvd.buildingcompany;

public class Design {
    private Project project;
    private BuildingType buildingType;
    private int floorsNumber;
    private int areaSize;

    public Design(Project project, int floorsNumber, int areaSize) {
        this.project = project;
        this.floorsNumber = floorsNumber;
        this.areaSize = areaSize;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public int getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(int floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    public int getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(int areaSize) {
        this.areaSize = areaSize;
    }
}

package com.solvd.buildingcompany.models;

public class Blueprint {
    private int floorCount;
    private int areaSize;
    private int roomsCount;
    private int windowsCount;
    private int doorsCount;

    public Blueprint(int floorCount, int areaSize, int roomsCount, int windowsCount, int doorsCount) {
        this.floorCount = floorCount;
        this.areaSize = areaSize;
        this.roomsCount = roomsCount;
        this.windowsCount = windowsCount;
        this.doorsCount = doorsCount;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(int areaSize) {
        this.areaSize = areaSize;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public int getWindowsCount() {
        return windowsCount;
    }

    public void setWindowsCount(int windowsCount) {
        this.windowsCount = windowsCount;
    }

    public int getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(int doorsCount) {
        this.doorsCount = doorsCount;
    }
}
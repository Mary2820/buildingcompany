package com.solvd.buildingcompany.models;

public class Blueprint {
    private int floorCount;
    private int actualAreaSize;
    private int roomsCount;
    private int windowsCount;
    private int doorsCount;

    public Blueprint(int floorCount, int actualAreaSize, int roomsCount, int windowsCount, int doorsCount) {
        this.floorCount = floorCount;
        this.actualAreaSize = actualAreaSize;
        this.roomsCount = roomsCount;
        this.windowsCount = windowsCount;
        this.doorsCount = doorsCount;
    }

    public Blueprint() {}

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getActualAreaSize() {
        return actualAreaSize;
    }

    public void setActualAreaSize(int actualAreaSize) {
        System.out.println("Actual area size is added.");
        this.actualAreaSize = actualAreaSize;
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
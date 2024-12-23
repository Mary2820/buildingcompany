package com.solvd.buildingcompany.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Blueprint {
    private static final Logger logger = LogManager.getLogger(Blueprint.class.getName());
    private int floorCount;
    private int actualAreaSize;
    private int roomsCount;
    private int windowsCount;
    private int doorsCount;
    private int outletsCount;

    public Blueprint(int floorCount, int actualAreaSize, int roomsCount, int windowsCount, int doorsCount, int outletsCount) {
        this.floorCount = floorCount;
        this.actualAreaSize = actualAreaSize;
        this.roomsCount = roomsCount;
        this.windowsCount = windowsCount;
        this.doorsCount = doorsCount;
        this.outletsCount = outletsCount;
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
        logger.info("Actual area size is added.");
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

    public int getOutletsCount() {
        return outletsCount;
    }

    public void setOutletsCount(int outletsCount) {
        this.outletsCount = outletsCount;
    }
}
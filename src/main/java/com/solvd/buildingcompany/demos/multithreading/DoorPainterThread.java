package com.solvd.buildingcompany.demos.multithreading;

import com.solvd.buildingcompany.models.building.components.Door;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingDeque;

public class DoorPainterThread extends Thread {
    private static final Logger logger = LogManager.getLogger(DoorPainterThread.class.getName());
    private final BlockingDeque<Door> doorsQueue;

    public DoorPainterThread(BlockingDeque<Door> doorsQueue) {
        this.doorsQueue = doorsQueue;
    }

    @Override
    public void run() {
        Door door = doorsQueue.poll();

        while (door != null) {
            door.setPainted(true);
            logger.info("Door is painted by thread: {}", Thread.currentThread().getName());
            door = doorsQueue.poll();
        }
    }
}
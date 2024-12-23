package com.solvd.buildingcompany.demos.multithreading;

import com.solvd.buildingcompany.models.building.components.Door;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class DoorPainter {
    private static final Logger logger = LogManager.getLogger(DoorPainter.class.getName());

    public void paintDoors(List<Door> doors) {
        BlockingDeque<Door> doorsQueue = new LinkedBlockingDeque<>(doors.size());
        doorsQueue.addAll(doors);

        int threadsCount = 2;
        try (ExecutorService executor = Executors.newFixedThreadPool(threadsCount)) {
            for (int i = 0; i < threadsCount; i++) {
                executor.submit(new DoorPainterThread(doorsQueue));
            }
            executor.shutdown();
        }
    }
}
package com.solvd.buildingcompany.demos.multithreading;

import com.solvd.buildingcompany.models.building.components.Door;
import com.solvd.buildingcompany.models.building.components.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class WindowPainter {
    private static final Logger logger = LogManager.getLogger(WindowPainter.class.getName());

    public void paintWindows(List<Window> windows) {
        BlockingDeque<Window> windowsQueue = new LinkedBlockingDeque<>(windows.size());
        windowsQueue.addAll(windows);

        int threadsCount = 2;
        try (ExecutorService executor = Executors.newFixedThreadPool(threadsCount)) {
            for (int i = 0; i < threadsCount; i++) {
                executor.submit(new WindowPainterThread(windowsQueue));
            }
            executor.shutdown();
        }
    }
}

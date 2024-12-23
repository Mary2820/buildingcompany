package com.solvd.buildingcompany.demos.multithreading;

import com.solvd.buildingcompany.models.building.components.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingDeque;

public class WindowPainterThread implements Runnable{
    private static final Logger logger = LogManager.getLogger(WindowPainterThread.class.getName());
    private final BlockingDeque<Window> windowsQueue;

    public WindowPainterThread(BlockingDeque<Window> windowsQueue) {
        this.windowsQueue = windowsQueue;
    }

    @Override
    public void run() {
        Window window = windowsQueue.poll();

        while (window != null) {
            window.setPainted(true);
            logger.info("Window is painted by thread: {}", Thread.currentThread().getName());
            window = windowsQueue.poll();
        }
    }
}

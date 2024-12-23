package com.solvd.buildingcompany.demos.multithreading;

import com.solvd.buildingcompany.models.building.components.Outlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;

public class OutletInstallerThread implements Callable<Integer> {
    private static final Logger logger = LogManager.getLogger(OutletInstallerThread.class.getName());
    private final BlockingDeque<Outlet> outletsQueue;

    public OutletInstallerThread(BlockingDeque<Outlet> outletsQueue) {
        this.outletsQueue = outletsQueue;
    }

    @Override
    public Integer call() {
        int outletsInstalled = 0;
        Outlet outlet = outletsQueue.poll();

        while (outlet != null) {
            outlet.setInstalled(true);
            outletsInstalled++;
            logger.info("Outlet is installed by thread: {}", Thread.currentThread().getName());
            outlet = outletsQueue.poll();
        }

        return outletsInstalled;
    }
}

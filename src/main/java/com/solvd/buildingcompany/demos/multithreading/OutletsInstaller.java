package com.solvd.buildingcompany.demos.multithreading;

import com.solvd.buildingcompany.models.building.components.Outlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class OutletsInstaller {
    private static final Logger logger = LogManager.getLogger(OutletsInstaller.class.getName());

    public void install(List<Outlet> outlets) {
        BlockingDeque<Outlet> outletsQueue = new LinkedBlockingDeque<>(outlets.size());
        outletsQueue.addAll(outlets);

        int threadsCount = 3;

        ExecutorService executor = Executors.newFixedThreadPool(threadsCount);
        List<Future<Integer>> futures = new ArrayList<>();

        try {
            for (int i = 0; i < threadsCount; i++) {
                Future<Integer> future = executor.submit(new OutletInstallerThread(outletsQueue));
                futures.add(future);
            }
            executor.shutdown();

            int totalInstalledCount = 0;
            for (Future<Integer> future : futures) {
                Integer installedCount = future.get();
                logger.info("Outlets installed by one thread: {}", installedCount);
                totalInstalledCount += installedCount;
            }

            logger.info("Total outlets installed: {}", totalInstalledCount);
        } catch (Exception e) {
            logger.error("Error occurred during outlet installation", e);
        }
    }
}

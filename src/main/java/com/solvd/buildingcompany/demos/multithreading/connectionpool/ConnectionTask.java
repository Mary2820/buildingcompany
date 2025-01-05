package com.solvd.buildingcompany.demos.multithreading.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionTask implements Runnable {
    private static final Logger logger = LogManager.getLogger(ConnectionTask.class.getName());

    private final ConnectionPool pool;
    private final String threadName;
    private final int workDuration;

    public ConnectionTask(ConnectionPool pool, String threadName, int workDuration) {
        this.pool = pool;
        this.threadName = threadName;
        this.workDuration = workDuration;
    }

    @Override
    public void run() {
        MockConnection connection = null;
        try {
            if (pool.getAvailableConnections() == 0) {
                logger.info("{}: No available connections. Waiting for connection...", threadName);
            }
            connection = (MockConnection) pool.getConnection();
            logger.info("{}: Connection obtained!", threadName);
            Thread.sleep(workDuration);
        } catch (Exception e) {
            logger.error("{}: Error: {}", threadName, e.getMessage());
        } finally {
            if (connection != null) {
                pool.releaseConnection(connection);
                logger.info("{}: Connection released!", threadName);
            }
        }
    }
}

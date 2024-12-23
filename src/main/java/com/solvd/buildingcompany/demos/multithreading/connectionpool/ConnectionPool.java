package com.solvd.buildingcompany.demos.multithreading.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class.getName());
    private List<Connection> connections;
    private final int maxSize = 5;
    private int activeConnections = 0;
    private static ConnectionPool instance;

    public ConnectionPool(List<Connection> initialConnections) {
        if (initialConnections == null || initialConnections.isEmpty()) {
            throw new IllegalArgumentException("Initial connections list cannot be null or empty");
        }
        this.connections = initialConnections;
    }

    public static ConnectionPool getInstance(List<Connection> initialConnections) {
        if (instance == null) {
            instance = new ConnectionPool(initialConnections);
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        while (connections.isEmpty() || activeConnections >= maxSize) {
            try {
                logger.info("{}: Waiting for available connection...", Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread was interrupted while waiting for a connection", e);
            }
        }
        activeConnections++;
        return connections.removeLast();
    }

    public synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            connections.add(connection);
        }
    }

    public synchronized int getAvailableConnections() {
        return connections.size();
    }
}

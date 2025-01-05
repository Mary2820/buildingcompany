package com.solvd.buildingcompany.demos.multithreading.connectionpool;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private final BlockingQueue<Connection> connections;
    private static final int MAX_SIZE = 5;
    private static ConnectionPool instance;

    private ConnectionPool() {
        this.connections = new ArrayBlockingQueue<>(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++) {
            connections.add(new MockConnection());
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return connections.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Connection waiting interrupted", e);
        }
    }

    public void releaseConnection(Connection connection) {
            connections.add(connection);
    }

    public int getAvailableConnections() {
        return connections.size();
    }
}

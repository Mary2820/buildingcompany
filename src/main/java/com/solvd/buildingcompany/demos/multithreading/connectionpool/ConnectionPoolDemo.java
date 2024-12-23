package com.solvd.buildingcompany.demos.multithreading.connectionpool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPoolDemo {

    public static void main(String[] args) {
        List<Connection> mockConnections = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            mockConnections.add(new MockConnection());
        }

        ConnectionPool pool = ConnectionPool.getInstance(mockConnections);

        Runnable task1 = new ConnectionTask(pool, "Thread 1", 1000);
        Runnable task2 = new ConnectionTask(pool, "Thread 2", 800);
        Runnable task3 = new ConnectionTask(pool, "Thread 3", 1200);
        Runnable task4 = new ConnectionTask(pool, "Thread 4", 1000);
        Runnable task5 = new ConnectionTask(pool, "Thread 5", 1500);
        Runnable task6 = new ConnectionTask(pool, "Thread 6", 1000);

        ExecutorService executor = Executors.newFixedThreadPool(6);

        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        executor.execute(task4);
        executor.execute(task5);
        executor.execute(task6);

        executor.shutdown();
    }
}

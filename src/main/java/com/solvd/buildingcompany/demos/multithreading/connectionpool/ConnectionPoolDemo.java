package com.solvd.buildingcompany.demos.multithreading.connectionpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPoolDemo {

    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance();

        Runnable task1 = new ConnectionTask(pool, "Thread 1", 1000);
        Runnable task2 = new ConnectionTask(pool, "Thread 2", 800);
        Runnable task3 = new ConnectionTask(pool, "Thread 3", 1200);
        Runnable task4 = new ConnectionTask(pool, "Thread 4", 1000);
        Runnable task5 = new ConnectionTask(pool, "Thread 5", 1500);
        Runnable task6 = new ConnectionTask(pool, "Thread 6", 1000);
        Runnable task7 = new ConnectionTask(pool, "Thread 7", 2000);
        Runnable task8 = new ConnectionTask(pool, "Thread 8", 1300);


        ExecutorService executor = Executors.newFixedThreadPool(6);

        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        executor.execute(task4);
        executor.execute(task5);
        executor.execute(task6);
        executor.execute(task7);
        executor.execute(task8);

        executor.shutdown();
    }
}

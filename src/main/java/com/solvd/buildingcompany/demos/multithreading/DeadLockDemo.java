package com.solvd.buildingcompany.demos.multithreading;

import com.solvd.buildingcompany.Main;
import com.solvd.buildingcompany.models.Project;
import com.solvd.buildingcompany.models.participants.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeadLockDemo {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Customer customer = new Customer("Emma", "Sullivan", "+48 455 741 223");
        Project project = customer.planProject();

        Thread thread1 = new Thread(() -> {
            logger.info("Thread 1: Attempting to lock customer");
            synchronized (customer) {
                logger.info("Thread 1: Locked customer");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    logger.error(e);
                }

                logger.info("Thread 1: Attempting to lock project");
                synchronized (project) {
                    logger.info("Thread 1: Locked project");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            logger.info("Thread 2: Attempting to lock project");
            synchronized (project) {
                logger.info("Thread 2: Locked project");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    logger.error(e);
                }

                logger.info("Thread 2: Attempting to lock customer");
                synchronized (customer) {
                    logger.info("Thread 2: Locked customer");
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            logger.error(e);
        }

        logger.info("Execution completed");
    }
}

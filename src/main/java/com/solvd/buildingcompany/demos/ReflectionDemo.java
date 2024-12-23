package com.solvd.buildingcompany.demos;

import com.solvd.buildingcompany.Main;
import com.solvd.buildingcompany.models.Blueprint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            Class<?> buildingClass = Class.forName("com.solvd.buildingcompany.models.building.Building");
            Constructor<?> buildingConstructor = buildingClass.getConstructor();
            Object building = buildingConstructor.newInstance();

            Field[] fields = building.getClass().getFields();
            Method buildingClassMethod = buildingClass.getMethod("getWindows");
            buildingClassMethod.invoke(building);

            Class<?> customerClass = Class.forName("com.solvd.buildingcompany.models.participants.Customer");
            Constructor<?> customerConstructor = customerClass.getConstructor();
            Object customer = customerConstructor.newInstance();

            Method getName = customerClass.getMethod("getName");
            getName.invoke(customer);

            Method isBlueprintApproved = customerClass.getMethod("isBlueprintApproved", Blueprint.class, int.class);
            isBlueprintApproved.invoke(customer, new Blueprint(4, 1500, 120, 250,
                    130, 300), 1500);

            Class<?> companyClass = Class.forName("com.solvd.buildingcompany.models.Company");
            Constructor<?> companyConstructor = companyClass.getConstructor();
            Object company = companyConstructor.newInstance();

            logger.info("Fields of companyClass:");
            Arrays.stream(companyClass.getDeclaredFields())
                    .forEach(field -> logger.info(" - {} ({})", field.getName(), field.getType().getName()));

            logger.info("Methods of companyClass:");
            Arrays.stream(companyClass.getDeclaredMethods())
                    .forEach(method -> logger.info(" - {}", method.getName()));

            logger.info("Constructors of companyClass:");
            Arrays.stream(companyClass.getConstructors())
                    .forEach(constructor -> logger.info(" - {}", constructor));
        } catch (Exception e) {
            logger.error(e);
        }
    }
}

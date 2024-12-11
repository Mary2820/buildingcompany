package com.solvd.buildingcompany.models.participants;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.exceptions.IncompleteBuildingException;
import com.solvd.buildingcompany.models.building.Building;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Inspector {
    private static final Logger logger = LogManager.getLogger(Inspector.class.getName());

    private String name;
    private String lastName;
    private int yearsOfExperience;
    private int licenseNumber;

    public Inspector(String name, String lastName, int yearsOfExperience, int licenseNumber) {
        this.name = name;
        this.lastName = lastName;
        this.yearsOfExperience = yearsOfExperience;
        this.licenseNumber = licenseNumber;
    }

    public Inspector() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void inspectBuilding(Building building) throws IncompleteBuildingException {
        logger.info("Inspector {} {} inspects the building.\n", getName(), getLastName());

        Map<BuildingStage, Object> buildingComponents = new HashMap<>();
        buildingComponents.put(BuildingStage.FOUNDATION, building.getFoundation());
        buildingComponents.put(BuildingStage.WALLS, building.getWalls());
        buildingComponents.put(BuildingStage.ROOF, building.getRoof());
        buildingComponents.put(BuildingStage.DOORS, building.getDoors());
        buildingComponents.put(BuildingStage.WINDOWS, building.getWindows());
        buildingComponents.put(BuildingStage.ELECTRICAL_SYSTEM, building.getElectricalSystem());
        buildingComponents.put(BuildingStage.GAS_SYSTEM, building.getGasSystem());
        buildingComponents.put(BuildingStage.PLUMBING_SYSTEM, building.getPlumbingSystem());

        List<BuildingStage> projectStages = building.getProject().getStages();
        boolean isCompleted = projectStages.stream().allMatch(stage -> buildingComponents.getOrDefault(stage,
                null) != null);

        if (isCompleted) {
            building.setIsBuilt(true);
            logger.info("Building passed the inspection and is marked as completed.");
        } else {
            throw new IncompleteBuildingException("Building is not completed. Some required components are missing.");
        }
    }
}
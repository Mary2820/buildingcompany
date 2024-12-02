package com.solvd.buildingcompany.models.participants;

import com.solvd.buildingcompany.exceptions.IncompleteBuildingException;
import com.solvd.buildingcompany.models.building.Building;

import java.util.Arrays;
import java.util.Objects;

public class Inspector {
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
        System.out.printf("Inspector %s %s inspects the building.\n", getName(), getLastName());
        Object[] buildingComponents = {building.getFoundation(), building.getWalls(), building.getRoof(),
                building.getDoors(), building.getWindows(), building.getElectricalSystem(), building.getGasSystem(),
                building.getPlumbingSystem()};

        boolean isComponentsBuilt = Arrays.stream(buildingComponents).allMatch(Objects::nonNull);
        if (isComponentsBuilt) {
            building.setIsBuilt(isComponentsBuilt);
        } else {
            throw new IncompleteBuildingException("Building is not completed.");
        }

    }
}
package com.solvd.buildingcompany.empoyees;

import com.solvd.buildingcompany.BuildingActivity;
import jdk.jshell.spi.ExecutionControl;

public class Builder extends Employee{
    private BuildingActivity task;

    public Builder(String name, String lastName, int workExperience, int salary) {
        super(name, lastName, workExperience, salary);
    }

    public BuildingActivity getTask() {
        return task;
    }

    public void setTask(BuildingActivity task) {
        this.task = task;
    }

    public void build(BuildingActivity task) throws ExecutionControl.NotImplementedException {
        switch (task) {
            case MAKE_FOUNDATION:
                System.out.println("Builder is making the fundation");
                break;
            case BUILD_WALLS:
                System.out.println("Builder is building walls");
                break;
            case MAKE_ROOF:
                System.out.println("Builder is making a roof");
                break;
            case INSTALL_WINDOWS_AND_DOORS:
                System.out.println("Builder is installing windows and doors");
                break;
            case CONDUCT_ELECTRICITY:
                System.out.println("Builder is conducting electricity");
                break;
            case CONDUCT_WATTER:
                System.out.println("Builder is conducting water");
                break;
            case CONDUCT_GAS:
                System.out.println("Builder is conducting gas");
            default:
                throw new ExecutionControl.NotImplementedException("Unexpected enum value");
        }


    }


}

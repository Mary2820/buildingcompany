package com.solvd.buildingcompany.empoyees;

import com.solvd.buildingcompany.BuildingActivity;

public class ConstructionEngineer extends Employee{
    private BuildingActivity task;

    public ConstructionEngineer(String name, String lastName, int workExperience, int salary) {
        super(name, lastName, workExperience, salary);
    }

    public BuildingActivity getTask() {
        return task;
    }

    public void setTask(BuildingActivity task) {
        this.task = task;
    }
}

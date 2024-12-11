package com.solvd.buildingcompany.interfaces.functionalinterfaces;

import com.solvd.buildingcompany.models.Project;

@FunctionalInterface
public interface ICalculateProjectTime {
    int calculate(Project project);
}

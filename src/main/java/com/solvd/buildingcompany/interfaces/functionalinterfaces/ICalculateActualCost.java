package com.solvd.buildingcompany.interfaces.functionalinterfaces;

import com.solvd.buildingcompany.models.Project;

@FunctionalInterface
public interface ICalculateActualCost {
    double calculate(Project project);
}

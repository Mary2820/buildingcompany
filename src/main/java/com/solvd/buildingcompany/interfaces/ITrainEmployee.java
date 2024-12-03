package com.solvd.buildingcompany.interfaces;

import com.solvd.buildingcompany.models.participants.staff.Employee;

public interface ITrainEmployee {
    void provideTraining(String trainingTopic, Employee employee);
}


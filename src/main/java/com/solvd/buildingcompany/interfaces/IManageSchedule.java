package com.solvd.buildingcompany.interfaces;

import java.time.LocalDate;

public interface IManageSchedule {
    void setDeadlineDate(LocalDate date);
    LocalDate getDeadlineDate();
}

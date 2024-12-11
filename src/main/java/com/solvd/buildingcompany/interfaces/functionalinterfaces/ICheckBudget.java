package com.solvd.buildingcompany.interfaces.functionalinterfaces;

import com.solvd.buildingcompany.models.Budget;

@FunctionalInterface
public interface ICheckBudget {
    boolean isBudgetExceeded(Budget budget, double actualExpenses);
}

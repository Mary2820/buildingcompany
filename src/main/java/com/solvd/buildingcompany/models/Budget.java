package com.solvd.buildingcompany.models;

public class Budget {
    private double planedExpenses;
    private double materialExpenses;
    private double otherExpenses;

    public Budget(double planedExpenses) {
        this.planedExpenses = planedExpenses;
    }

    public Budget() {}

    public double getPlanedExpenses() {
        return planedExpenses;
    }

    public void setPlanedExpenses(double planedExpenses) {
        this.planedExpenses = planedExpenses;
    }

    public double getMaterialExpenses() {
        return materialExpenses;
    }

    public void setMaterialExpenses(double materialExpenses) {
        this.materialExpenses = materialExpenses;
    }

    public double getOtherExpenses() {
        return otherExpenses;
    }

    public void setOtherExpenses(double otherExpenses) {
        this.otherExpenses = otherExpenses;
    }
}

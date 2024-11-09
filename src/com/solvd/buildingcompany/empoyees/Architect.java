package com.solvd.buildingcompany.empoyees;


import com.solvd.buildingcompany.Design;

public class Architect extends Employee{
    Design design;

    public Architect(String name, String lastName, int workExperience, int salary) {
        super(name, lastName, workExperience, salary);
    }

    public Design getDesign() {
        return design;
    }

    public void setDesign(Design design) {
        this.design = design;
    }



}

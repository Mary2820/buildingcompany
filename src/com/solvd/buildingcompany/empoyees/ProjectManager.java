package com.solvd.buildingcompany.empoyees;

import com.solvd.buildingcompany.Design;
import com.solvd.buildingcompany.Project;

public class ProjectManager extends Employee {
    private Project projectInformation;
    private Design design;
    public ProjectManager(String name, String lastName, int workExperience, int salary) {
        super(name, lastName, workExperience, salary);
    }

    public Project getProjectInformation() {
        return projectInformation;
    }

    public void setProjectInformation(Project projectInformation) {
        System.out.println(name + lastName + " is collecting information about the project");
        this.projectInformation = projectInformation;
    }

    public Design getDesign() {
        return design;
    }

    public void setDesign(Design design) {
        this.design = design;
    }
}

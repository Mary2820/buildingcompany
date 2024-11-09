package com.solvd.buildingcompany;

import com.solvd.buildingcompany.empoyees.Architect;
import com.solvd.buildingcompany.empoyees.Builder;
import com.solvd.buildingcompany.empoyees.ConstructionEngineer;
import com.solvd.buildingcompany.empoyees.ProjectManager;
import jdk.jshell.spi.ExecutionControl;

public class HouseConstruction {
    public static void main(String[] args) throws ExecutionControl.NotImplementedException {
        Company company = new Company(
                new CompanyInformation("Super company", 345, 345555555,
                        "building"));
        Customer customer = new Customer("Josua", 789123456);
        ProjectManager projectManager = new ProjectManager("Alice", "Kowal", 5, 10500);
        Architect architect = new Architect("John", "Gray", 3, 7800);
        ConstructionEngineer engineer = new ConstructionEngineer("Harry", "Novak", 10,
                12000);
        Builder builder = new Builder("Nikolay", "Vader", 8, 6000);


        customer.setProject(new Project(BuildingType.INDUSTRIAL_BUILDING, 800000, "Warsaw, Pilkow Street 125B"));

        projectManager.setProjectInformation(customer.getProject());
        architect.setDesign(new Design(projectManager.getProjectInformation(), 3, 1800));
        projectManager.setDesign(architect.getDesign());

        if(customer.isDesignApproved(projectManager.getDesign())) {
            for (BuildingActivity value : BuildingActivity.values()) {
                engineer.setTask(value);
                builder.build(engineer.getTask());
            }






        }






    }


}

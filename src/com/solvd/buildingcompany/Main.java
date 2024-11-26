package com.solvd.buildingcompany;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.exceptions.BlueprintNotApprovedException;
import com.solvd.buildingcompany.exceptions.CustomerNotFoundException;
import com.solvd.buildingcompany.exceptions.IncompleteBuildingException;
import com.solvd.buildingcompany.models.Blueprint;
import com.solvd.buildingcompany.models.Company;
import com.solvd.buildingcompany.models.Project;
import com.solvd.buildingcompany.models.participants.*;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.participants.staff.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Emma", "Sullivan", "+48 455 741 223");
        Project project = customer.planProject();
        Company company = new Company("SuperCompany", "+48 123 456 789", new ArrayList<>(),
                new HashMap<>());

        company.addCustomer(customer);

        try {
            company.getCustomerInfo("CL1");
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            company.addCustomer(customer);
        }

        company.addProject(project);

        Architect architect = new Architect("Michael", "Thompson", 5, 10500);
        ConstructionEngineer constructionEngineer = new ConstructionEngineer("James", "Johnson",
                10);

        Builder builder = new Builder("Davis", "Anderson", 8,
                new BuildingStage[]{BuildingStage.FOUNDATION, BuildingStage.WALLS, BuildingStage.ROOF});
        Plumber plumber = new Plumber("James", "Walker", 15,
                new BuildingStage[]{BuildingStage.PLUMBING_SYSTEM});
        Electrician electrician = new Electrician("Thomas", "Wall", 9,
                new BuildingStage[]{BuildingStage.ELECTRICAL_SYSTEM});
        GasTechnician gasTechnician = new GasTechnician("Daniel", "Brooks", 11,
                new BuildingStage[]{BuildingStage.GAS_SYSTEM});

        DoorInstaller installer = new DoorInstaller("Mike", "Lars",
                7, new BuildingStage[]{BuildingStage.DOORS, BuildingStage.WINDOWS});

        Employee[] constructionTeam = {builder, installer, plumber, electrician, gasTechnician};

        company.assignTeamToProject(constructionTeam);

        Blueprint blueprint = architect.createBlueprint();

        try {
            customer.isBlueprintApproved(blueprint, project.getExpectedAreaSize());
        } catch (BlueprintNotApprovedException e) {
            System.out.println(e.getMessage());
            blueprint.setActualAreaSize(project.getExpectedAreaSize());
        }

        project.setBlueprint(blueprint);

        Building building = new Building(project);

        constructionEngineer.assignEmployeesTasks(constructionTeam, building);

        Inspector inspector = new Inspector("Oliver", "Blanko", 11, 555489);
        inspector.inspectBuilding(building);

        try {
            if (!building.isBuilt()) {
               throw new IncompleteBuildingException("Building isn't finished");
            }
        } catch (IncompleteBuildingException e) {
            System.out.println(e.getMessage());
            constructionEngineer.assignEmployeesTasks(constructionTeam, building);
        }

        constructionEngineer.completeProject(project);
        company.removeProject(project);

        company.removeCustomer("CL1");
    }
}
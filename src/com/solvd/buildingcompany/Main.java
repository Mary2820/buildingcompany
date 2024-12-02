package com.solvd.buildingcompany;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.exceptions.*;
import com.solvd.buildingcompany.models.Blueprint;
import com.solvd.buildingcompany.models.Company;
import com.solvd.buildingcompany.models.Project;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.participants.Customer;
import com.solvd.buildingcompany.models.participants.Inspector;
import com.solvd.buildingcompany.models.participants.staff.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Emma", "Sullivan", "+48 455 741 223");
        Project project = customer.planProject();

        Company company = new Company("SuperCompany", "+48 123 456 789", new ArrayList<>(),
                new HashMap<>());

        try {
            company.addCustomer(customer);
        } catch (CustomerNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            company.addProject(project);
        } catch (ProjectNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

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
            System.out.println("Error: " + e.getMessage());
            blueprint.setActualAreaSize(project.getExpectedAreaSize());
        }

        project.setBlueprint(blueprint);

        Building building = new Building(project);

        constructionEngineer.assignEmployeesTasks(constructionTeam, building);

        Inspector inspector = new Inspector("Oliver", "Blanko", 11, 555489);

        try {
            inspector.inspectBuilding(building);
        } catch (IncompleteBuildingException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        constructionEngineer.completeProject(project);

        try {
            constructionEngineer.generateProjectReport(project, customer);
        } catch (ReportGenerationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        company.removeProject(project);

        try {
            company.removeCustomer("CL1");
        } catch (CustomerNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
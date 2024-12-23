package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.enums.ProficiencyLevel;
import com.solvd.buildingcompany.models.Blueprint;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.utils.linkedlist.MyLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Architect extends Employee{
    private static final Logger logger = LogManager.getLogger(Architect.class.getName());

    private List<String> awards;

    public Architect(String name, String lastName, int yearsOfExperience, ProficiencyLevel level, double salary) {
        super(name, lastName, yearsOfExperience, level, salary);
    }

    public Architect() {super();}

    public Blueprint createBlueprint() {
        logger.info("Architect {} {} creates a blueprint.\n", getName(), getLastName());
        return new Blueprint(4, 1800, 100, 15,
                12, 31);
    }

    @Override
    public void createPlan() {
        logger.info("Architect outlines the design stages, materials, and technical requirements..");
    }

    @Override
    public void prepareToWork() {
        logger.info("Architect assembles blueprints, permits, and resources needed for the build");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        logger.info("Architect ensures each phase aligns with architectural design and standards.");
    }

    @Override
    public void addReport(MyLinkedList<String> reports) {
        logger.info("Architect documents construction milestones, design adjustments, and compliance updates..");
    }

    @Override
    public void maintainEquipment() {
        logger.info("Architect keeps architectural tools and equipment calibrated and ready for use.");
    }

    @Override
    public void ReportIncident(String incidentDetails) {
        logger.info("Architect reports an incident: {}", incidentDetails);
    }

    @Override
    public void ExecuteEmergencyProtocol() {
        logger.info("Architect tells company about incident and calls 911");
    }

    @Override
    public String AssessDamage() {
        logger.info("Architect is assessing damage.");
        return "Damage assessment completed.";
    }
}
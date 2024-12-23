package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.demos.multithreading.DoorPainter;
import com.solvd.buildingcompany.demos.multithreading.WindowPainter;
import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.enums.ProficiencyLevel;
import com.solvd.buildingcompany.models.Blueprint;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.components.*;
import com.solvd.buildingcompany.utils.linkedlist.MyLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DoorInstaller extends Employee{
    private static final Logger logger = LogManager.getLogger(DoorInstaller.class.getName());

    private static final int MASK = 2;
    private boolean hasCompletedTraining;

    public DoorInstaller(String name, String lastName, int yearsOfExperience, BuildingStage[] responsibilities,
                         ProficiencyLevel proficiencyLevel, double salary) {
        super(name, lastName, yearsOfExperience, proficiencyLevel, salary);

        setResponsibilities(responsibilities);
    }

    public DoorInstaller() {super();}

    public boolean hasCompletedTraining() {
        return hasCompletedTraining;
    }

    public void setHasCompletedTraining(boolean hasCompletedTraining) {
        this.hasCompletedTraining = hasCompletedTraining;
    }

    @Override
    public void createPlan() {
        logger.info("DoorInstaller studies blueprints and measurements to understand the specifications for" +
                " each door and window. ");
    }

    @Override
    public void prepareToWork() {
        logger.info("DoorInstaller ensures openings are level, clean, and ready for fitting, making necessary" +
                " adjustments for proper alignment.");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        Blueprint blueprint = building.getProject().getBlueprint();
        switch (buildingStage) {
            case WINDOWS:
                logger.info("Installer {} {} installs windows.\n", getName(), getLastName());
                installWindows(building, blueprint.getWindowsCount());
                building.getProject().increaseMaterialExpenses(8000);
                break;
            case DOORS:
                logger.info("Installer {} {} installs doors.\n", getName(), getLastName());
                installDoors(building, blueprint.getDoorsCount());
                building.getProject().increaseMaterialExpenses(8000);
                break;
        }
    }

    @Override
    public void addReport(MyLinkedList<String> reports) {
        reports.add("DoorInstaller completed his work.");
        logger.info("DoorInstaller checks each installation for airtight seals, insulation, and quality" +
                " to ensure durability and energy efficiency.");
    }

    @Override
    public void maintainEquipment() {
        logger.info("DoorInstaller Keeps installation tools in top condition, performing regular checks and" +
                " maintenance for accuracy and safety.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (hashCode() != o.hashCode()) return false;
        DoorInstaller doorInstaller = (DoorInstaller) o;
        return Objects.equals(hasCompletedTraining, doorInstaller.hasCompletedTraining() );
    }

    @Override
    public int hashCode() {
        return MASK + super.hashCode() + Objects.hashCode(hasCompletedTraining);
    }

    @Override
    public String toString() {
        return "DoorInstaller{" + "name=" + getName() + ", lastName=" + getLastName() + '}';
    }

    private void installWindows(Building building, int windowsCount) {
        List<Window> windows = IntStream.rangeClosed(0, windowsCount)
                .mapToObj(i -> new Window(1.5, 1.2, 0.05, "double-pane glass"))
                .collect(Collectors.toList());

        WindowPainter windowPainter = new WindowPainter();
        windowPainter.paintWindows(windows);
        building.setWindows(windows);
    }

    private void installDoors(Building building, int doorsCount) {
        List<Door> doors = IntStream.rangeClosed(0, doorsCount)
                .mapToObj(i -> new Door(0.9, 2, true))
                .collect(Collectors.toList());

        DoorPainter doorPainter = new DoorPainter();
        doorPainter.paintDoors(doors);

        building.setDoors(doors);
    }

    @Override
    public void ReportIncident(String incidentDetails) {
        logger.info("Door installer reports an incident: {}", incidentDetails);
    }

    @Override
    public void ExecuteEmergencyProtocol() {
        logger.info("Door installer leaves the construction site and notifies the construction engineer of" +
                " the incident.");
    }

    @Override
    public String AssessDamage() {
        logger.info("Door installer is assessing damage.");
        return "Damage assessment completed.";
    }

    public void paintDoor(Door door) {
        door.setPainted(true);
        logger.info("Door is painted");
    }
}
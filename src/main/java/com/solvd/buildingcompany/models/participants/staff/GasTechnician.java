package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.enums.ProficiencyLevel;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.components.GasSystem;
import com.solvd.buildingcompany.utils.linkedlist.MyLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class GasTechnician extends Employee{
    private static final Logger logger = LogManager.getLogger(GasSystem.class.getName());
    private static final int MASK = 4;
    private boolean hasSafetyCertificate;

    public GasTechnician(String name, String lastName, int yearsOfExperience, BuildingStage[] responsibilities,
                         ProficiencyLevel proficiencyLevel, double salary) {
        super(name, lastName, yearsOfExperience, proficiencyLevel, salary);

        setResponsibilities(responsibilities);
    }

    public GasTechnician() {super();}

    public boolean hasSafetyCertificate() {
        return hasSafetyCertificate;
    }

    public void setHasSafetyCertificate(boolean hasSafetyCertificate) {
        this.hasSafetyCertificate = hasSafetyCertificate;
    }

    @Override
    public void createPlan() {
        logger.info("GasTechnician studies blueprints and specifications to understand the layout and" +
                " requirements of gas piping and appliances.");
    }

    @Override
    public void prepareToWork() {
        logger.info("GasTechnician ensures the area is safe, checks for existing gas lines, and gathers" +
                " necessary tools and equipment for installation or repair. ");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        logger.info("GasTechnician {} {} installs the gas system.\n", getName(), getLastName() );
        building.setGasSystem(new GasSystem("Propane"));

        building.getProject().increaseMaterialExpenses(8000);
    }

    @Override
    public void addReport(MyLinkedList<String> reports) {
        reports.add("GasTechnician completed his work.");
        logger.info("GasTechnician uses specialized equipment to check for gas leaks, pressure stability," +
                " and ensures that all installations are safe and functional. ");
    }

    @Override
    public void maintainEquipment() {
        logger.info("GasTechnician inspects and calibrates tools, ensuring they are safe, reliable," +
                " and ready for future use. ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (hashCode() != o.hashCode()) return false;
        GasTechnician gasTechnician = (GasTechnician) o;
        return Objects.equals(hasSafetyCertificate(), gasTechnician.hasSafetyCertificate());
    }

    @Override
    public int hashCode() {
        return MASK + super.hashCode() + Objects.hashCode(hasSafetyCertificate);
    }

    @Override
    public String toString() {
        return "GasTechnician{" + "name=" + getName() + ", lastName=" + getLastName() + '}';
    }

    @Override
    public void ReportIncident(String incidentDetails) {
        logger.info("Gas technician reports an incident: {}", incidentDetails);
    }

    @Override
    public void ExecuteEmergencyProtocol() {
        logger.info("Gas technician leaves the construction site and notifies the construction engineer of" +
                " the incident.");
    }

    @Override
    public String AssessDamage() {
        logger.info("Gas technician is assessing damage.");
        return "Damage assessment completed.";
    }
}
package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.enums.ProficiencyLevel;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.components.Foundation;
import com.solvd.buildingcompany.models.building.components.Roof;
import com.solvd.buildingcompany.models.building.components.Wall;
import com.solvd.buildingcompany.utils.linkedlist.MyLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Builder extends Employee{
    private static final Logger logger = LogManager.getLogger(Builder.class.getName());

    private static final int MASK = 1;
    private String[] skills;

    public Builder(String name, String lastName, int yearsOfExperience, BuildingStage[] responsibilities,
                   ProficiencyLevel proficiencyLevel, double salary) {
        super(name, lastName, yearsOfExperience, proficiencyLevel, salary);

        setResponsibilities(responsibilities);
    }

    public Builder() {super();}

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    @Override
    public void createPlan() {
        logger.info("Builder studies architectural plans and understands construction requirements" +
                " and specifications.");
    }

    @Override
    public void prepareToWork() {
        logger.info("Builder clears the land, sets up foundations, and gathers necessary materials and equipment.");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        switch (buildingStage) {
            case FOUNDATION:
                logger.info("Builder {} {} %s pours the foundation.\n", getName(), getLastName());
                building.setFoundation(new Foundation(1500,  "concrete" ));
                building.getProject().increaseMaterialExpenses(10000);
                break;
            case WALLS:
                logger.info("Builder {} {} %s builds walls.\n", getName(), getLastName());
                building.setWalls(new Wall[]{
                        new Wall(50, 10, 1.5),
                        new Wall(50, 10, 1.5),
                        new Wall(50, 10, 1.5),
                        new Wall(50, 10, 1.5),}
                );
                building.getProject().increaseMaterialExpenses(15000);
                break;
            case ROOF:
                logger.info("Builder {} {} %s installs roofing.\n", getName(), getLastName());
                building.setRoof(new Roof("flat roof","PVC membrane", 1500));
                building.getProject().increaseMaterialExpenses(5000);
        }
    }

    @Override
    public void addReport(MyLinkedList<String> reports) {
        reports.add("Builder completed his work.");
        logger.info("Builder ensures each stage meets building codes and quality standards before moving " +
                "to the next phase.");
    }

    @Override
    public void maintainEquipment() {
        logger.info("Builder completes finishing touches, site cleanup, and prepares the structure for " +
                "inspection and handover.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (hashCode() != o.hashCode()) return false;
        Builder builder = (Builder) o;
        return Arrays.equals(getSkills(), builder.getSkills());
    }

    @Override
    public int hashCode() {
        return MASK + super.hashCode() + Arrays.hashCode(skills);
    }

    @Override
    public String toString() {
        return "Builder{" + "name=" + getName() + ", lastName=" + getLastName() + '}';
    }

    @Override
    public void ReportIncident(String incidentDetails) {
        logger.info("Builder reports an incident: {}", incidentDetails);
    }

    @Override
    public void ExecuteEmergencyProtocol() {
        logger.info("Builder leaves the construction site and notifies the construction engineer of the incident.");
    }

    @Override
    public String AssessDamage() {
        logger.info("Builder is assessing damage.");
        return "Damage assessment completed.";
    }
}
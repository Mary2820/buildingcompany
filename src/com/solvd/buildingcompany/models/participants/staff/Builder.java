package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.components.Foundation;
import com.solvd.buildingcompany.models.building.components.Roof;
import com.solvd.buildingcompany.models.building.components.Wall;

import java.util.Arrays;

public class Builder extends Employee{
    private static final int MASK = 1;
    private String[] skills;

    public Builder(String name, String lastName, int yearsOfExperience, BuildingStage[] responsibilities) {
        super(name, lastName, yearsOfExperience);

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
        System.out.println("Builder studies architectural plans and understands construction requirements" +
                " and specifications.");
    }

    @Override
    public void prepareToWork() {
        System.out.println("Builder clears the land, sets up foundations, and gathers necessary materials and equipment.");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        switch (buildingStage) {
            case FOUNDATION:
                System.out.printf("Builder %s %s pours the foundation.\n", getName(), getLastName());
                building.setFoundation(new Foundation(1500,  "concrete" ));
                break;
            case WALLS:
                System.out.printf("Builder %s %s builds walls.\n", getName(), getLastName());
                building.setWalls(new Wall[]{
                        new Wall(50, 10, 1.5),
                        new Wall(50, 10, 1.5),
                        new Wall(50, 10, 1.5),
                        new Wall(50, 10, 1.5),}
                );
                break;
            case ROOF:
                System.out.printf("Builder %s %s installs roofing.\n", getName(), getLastName());
                building.setRoof(new Roof("flat roof","PVC membrane", 1500));
        }
    }

    @Override
    public void submitReport() {
        System.out.println("Builder ensures each stage meets building codes and quality standards before moving " +
                "to the next phase.");
    }

    @Override
    public void maintainEquipment() {
        System.out.println("Builder completes finishing touches, site cleanup, and prepares the structure for " +
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
        System.out.println("Builder reports an incident: " + incidentDetails);
    }

    @Override
    public void ExecuteEmergencyProtocol() {
        System.out.println("Builder leaves the construction site and notifies the construction engineer of the incident.");
    }

    @Override
    public String AssessDamage() {
        System.out.println("Builder is assessing damage.");
        return "Damage assessment completed.";
    }
}
package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.models.Project;
import com.solvd.buildingcompany.models.building.Building;

public class ConstructionEngineer extends Employee{
    private String specialization;

    public ConstructionEngineer(String name, String lastName, int yearsOfExperience, boolean isManagement) {
        super(name, lastName, yearsOfExperience);

        this.isManagement = isManagement;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void createPlan() {
        System.out.println("Engineer designs a detailed plan that includes materials, scheduling, and safety protocols" +
                " for efficient project execution.");
    }

    @Override
    public void prepareToWork() {
        System.out.println("Engineer gathers permits, verifies safety standards, and ensures all resources and" +
                " equipment are ready for the project.");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        System.out.println("Engineer oversees each stage of construction, coordinating with teams to ensure structural" +
                " integrity and adherence to specifications.");
    }

    @Override
    public void submitReport() {
        System.out.println("Engineer documents completed stages, quality assessments, and any adjustments for" +
                " regulatory compliance.");
    }

    @Override
    public void maintainEquipment() {
        System.out.println("Engineer inspects and maintains machinery and tools to ensure safe and efficient operation" +
                " on-site.");
    }

    public void completeProject(Project project) {
        System.out.println("Construction engineer is finishing the project.");
        project.setCompleted(true);
    }

    public void assignEmployeesTasks(Employee[] projectTeam, Building building) {
        for (Employee employee : projectTeam){
            if(employee.isManagement){
                continue;
            }

            assignEmployeeTask(employee, building);
        }
    }

    private void assignEmployeeTask(Employee employee, Building building){
        for (BuildingStage stage : employee.getResponsibilities()){
            System.out.printf("Construction engineer %s %s is assigning %s %s to do a task.\n", getName(), getLastName(),
                    employee.getName(), employee.getLastName());
            employee.work(building, stage);
        }
    }
}
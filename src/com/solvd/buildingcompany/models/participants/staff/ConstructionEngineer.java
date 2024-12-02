package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.exceptions.ReportGenerationException;
import com.solvd.buildingcompany.interfaces.ITrainEmployee;
import com.solvd.buildingcompany.models.Project;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.participants.Customer;
import com.solvd.buildingcompany.utils.MyLinkedList;

import java.io.FileWriter;
import java.io.IOException;

public class ConstructionEngineer extends Employee implements ITrainEmployee {
    private int salary;

    public ConstructionEngineer(String name, String lastName, int yearsOfExperience) {
        super(name, lastName, yearsOfExperience);
    }

    public ConstructionEngineer() {super();}

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    public void generateProjectReport(Project project, Customer customer) throws ReportGenerationException {
        try (FileWriter writer = new FileWriter("project_report.txt")) {
            writer.write("Project Report for customer : " + customer.getName() + " " + customer.getLastName() + "\n");
            writer.write("Is building completed: " + project.isCompleted() + "\n");

            MyLinkedList<String> reports = project.getReports();
            writer.write(reports.toString());
        } catch (IOException e) {
            throw new ReportGenerationException("Failed to generate project report for: " + customer.getName(), e);
        }
    }

    @Override
    public void addReport(MyLinkedList<String> reports) {
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

    public void assignEmployeesTasks(Employee[] team, Building building) {
        for (Employee employee : team){
            assignEmployeeTask(employee, building);
        }
    }

    private void assignEmployeeTask(Employee employee, Building building){
        for (BuildingStage stage : employee.getResponsibilities()){
            System.out.printf("Construction engineer %s %s is assigning %s %s to do a task.\n", getName(), getLastName(),
                    employee.getName(), employee.getLastName());
            employee.work(building, stage);
            employee.addReport(building.getProject().getReports());
        }
    }

    @Override
    public void ReportIncident(String incidentDetails) {
        System.out.println("Construction engineer reports an incident: " + incidentDetails);

    }

    @Override
    public void ExecuteEmergencyProtocol() {
        System.out.println("Construction engineer leaves the construction site and notifies the company of the incident.");
    }

    @Override
    public String AssessDamage() {
        System.out.println("Construction engineer is assessing damage.");
        return "Damage assessment completed.";
    }

    @Override
    public void provideTraining(String trainingTopic, Employee employee) {
        System.out.printf("Engineer provides %s training for %s", trainingTopic, employee);
    }
}
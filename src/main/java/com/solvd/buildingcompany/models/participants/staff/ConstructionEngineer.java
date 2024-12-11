package com.solvd.buildingcompany.models.participants.staff;

import com.solvd.buildingcompany.enums.BuildingStage;
import com.solvd.buildingcompany.enums.ProficiencyLevel;
import com.solvd.buildingcompany.exceptions.ReportGenerationException;
import com.solvd.buildingcompany.interfaces.functionalinterfaces.ICalculateActualCost;
import com.solvd.buildingcompany.interfaces.functionalinterfaces.ICalculateProjectTime;
import com.solvd.buildingcompany.interfaces.ITrainEmployee;
import com.solvd.buildingcompany.interfaces.functionalinterfaces.ICheckBudget;
import com.solvd.buildingcompany.models.Budget;
import com.solvd.buildingcompany.models.Project;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.participants.Customer;
import com.solvd.buildingcompany.utils.linkedlist.MyLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ConstructionEngineer extends Employee implements ITrainEmployee {
    private static final Logger logger = LogManager.getLogger(ConstructionEngineer.class.getName());
    private String skillDescription;

    public ConstructionEngineer(String name, String lastName, int yearsOfExperience, ProficiencyLevel proficiencyLevel,
                                double salary) {
        super(name, lastName, yearsOfExperience, proficiencyLevel, salary);
    }

    public ConstructionEngineer() {
        super();
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    @Override
    public void createPlan() {
        logger.info("Engineer designs a detailed plan that includes materials, scheduling, and safety protocols" +
                " for efficient project execution.");
    }

    @Override
    public void prepareToWork() {
        logger.info("Engineer gathers permits, verifies safety standards, and ensures all resources and" +
                " equipment are ready for the project.");
    }

    @Override
    public void work(Building building, BuildingStage buildingStage) {
        logger.info("Engineer oversees each stage of construction, coordinating with teams to ensure structural" +
                " integrity and adherence to specifications.");
    }

    public void addOtherExpenses(Budget budget) {
        budget.setOtherExpenses(5000);
    }

    public void generateProjectReport(Project project, Customer customer) throws ReportGenerationException {
        double actualExpenses = getActualProjectCost(project);
        try (FileWriter writer = new FileWriter("src/main/resources/project_report.txt")) {
            writer.write("Project Report for customer : " + customer.getName() + " " + customer.getLastName() + "\n");
            writer.write("Is building completed: " + project.isCompleted() + "\n");
            writer.write("Project duration: " + getProjectDuration(project) +  " days" + "\n");
            writer.write("Is a budget not exceeded " + checkBudget(project.getBudget(), actualExpenses) + "\n");

            MyLinkedList<String> reports = project.getReports();
            writer.write(reports.toString());
        } catch (IOException e) {
            throw new ReportGenerationException("Failed to generate project report for: " + customer.getName(), e);
        }
    }

    private int getProjectDuration(Project project) {
        ICalculateProjectTime timeCalculator = proj -> proj.getStages().stream().mapToInt(BuildingStage::getDurationInDays).sum();
        return timeCalculator.calculate(project);
    }

    @Override
    public void addReport(MyLinkedList<String> reports) {
        logger.info("Engineer documents completed stages, quality assessments, and any adjustments for" +
                " regulatory compliance.");
    }

    @Override
    public void maintainEquipment() {
        logger.info("Engineer inspects and maintains machinery and tools to ensure safe and efficient operation" +
                " on-site.");
    }

    public void completeProject(Project project) {
        logger.info("Construction engineer is finishing the project.");
        project.setCompleted(true);
    }

    public Double getActualProjectCost(Project project) {
        Budget budget = project.getBudget();
        ICalculateActualCost actualCostCalculator = proj -> Arrays.stream(proj.getTeam()).mapToDouble(Employee::getSalary)
                .sum() + budget.getMaterialExpenses() + budget.getOtherExpenses();
        return actualCostCalculator.calculate(project);
    }

    public Boolean checkBudget(Budget budget, double actualExpenses) {
        ICheckBudget budgetChecker = (bdg, exp) -> bdg.getPlanedExpenses() >= exp;
        return budgetChecker.isBudgetExceeded(budget, actualExpenses);
    }

    public void assignEmployeesTasks(Employee[] team, Building building) {
        Arrays.stream(team).forEach(employee -> assignEmployeeTask(employee, building,
                building.getProject().getStages()));
    }

    private void assignEmployeeTask(Employee employee, Building building, List<BuildingStage> projectStages) {
        Arrays.stream(employee.getResponsibilities())
                .filter(projectStages::contains)
                .forEach(stage -> {
                    logger.info("Construction engineer {} {} is assigning {} {} to do a task: {}.",
                            getName(), getLastName(),
                            employee.getName(), employee.getLastName(), stage.getDescription());

                    employee.work(building, stage);
                    employee.addReport(building.getProject().getReports());
                });
    }

    @Override
    public void ReportIncident(String incidentDetails) {
        logger.info("Construction engineer reports an incident: {}", incidentDetails);

    }

    @Override
    public void ExecuteEmergencyProtocol() {
        logger.info("Construction engineer leaves the construction site and notifies the company of the incident.");
    }

    @Override
    public String AssessDamage() {
        logger.info("Construction engineer is assessing damage.");
        return "Damage assessment completed.";
    }

    @Override
    public void provideTraining(String trainingTopic, Employee employee) {
        logger.info("Engineer provides {} training for {}", trainingTopic, employee);
    }
}
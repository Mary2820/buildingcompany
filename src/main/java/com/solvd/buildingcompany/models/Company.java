package com.solvd.buildingcompany.models;

import com.solvd.buildingcompany.exceptions.CustomerNotFoundException;
import com.solvd.buildingcompany.exceptions.ProjectNotFoundException;
import com.solvd.buildingcompany.interfaces.IHandleCustomer;
import com.solvd.buildingcompany.models.participants.Customer;
import com.solvd.buildingcompany.models.participants.staff.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class Company implements IHandleCustomer {
    private static final Logger logger = LogManager.getLogger(Company.class.getName());

    private String name;
    private String phoneNumber;
    private List<Project> projects;
    private Map<String, Customer> customers;

    public Company(String name, String phoneNumber, List<Project> projects,
                   Map<String, Customer> customers) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.projects = projects;
        this.customers = customers;
    }

    public Company() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<String, Customer> customers) {
        this.customers = customers;
    }

    public void addProject(Project project) throws ProjectNotFoundException {
        if (project == null) {
            throw new ProjectNotFoundException("Project is not found.");
        }

        logger.info("Company {} collects information about the project.\n", getName());
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public void assignTeamToProject(Employee[] team) {
        logger.info("Company {} assigns a team.\n", getName());
        projects.stream()
                .filter(project -> project.getTeam() == null)
                .findFirst()
                .ifPresent(project -> project.setTeam(team));
    }

    @Override
    public void addCustomer(Customer customer) throws CustomerNotFoundException {
        if (customer == null) {
            throw new CustomerNotFoundException("Customer is not found.");
        }
        logger.info("Customer {} {} orders a project.\n", customer.getName(), customer.getLastName());

        String customerId = "CL" + (customers.size() + 1);
        customers.put(customerId, customer);
        logger.info("Customer {} {} adds to list of company customers.\n", customer.getName(), customer.getLastName());
    }

    @Override
    public void removeCustomer(String customerId) throws CustomerNotFoundException {
        Customer removedCustomer = customers.remove(customerId);
        if (removedCustomer != null) {
            logger.info("Customer removed: {}", customerId);
        } else {
            throw new CustomerNotFoundException("Customer is not found.");
        }
    }

    @Override
    public String getCustomerInfo(String customerId) throws CustomerNotFoundException {
        if (!customers.containsKey(customerId)) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
        }
        return customers.get(customerId).toString();
    }

    @Override
    public void sendProgressReport(String customerId) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            logger.info("Progress report sent to: {}", customer.getName());
        } else {
            logger.info("Customer not found: {}", customerId);
        }
    }
}
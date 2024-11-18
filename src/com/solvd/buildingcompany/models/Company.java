package com.solvd.buildingcompany.models;

import com.solvd.buildingcompany.interfaces.IHandleCustomer;
import com.solvd.buildingcompany.models.participants.Customer;
import com.solvd.buildingcompany.models.participants.staff.Employee;

import java.util.List;
import java.util.Map;

public class Company implements IHandleCustomer {
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

    public void addProject(Project project) {
        System.out.printf("Company %s collects information about the project.\n", getName());
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public void assignTeamToProject(Employee[] team) {
        System.out.printf("Company %s assigns a team.\n", getName());
        for (Project project : projects) {
            if (project.getTeam() == null) {
                project.setTeam(team);
                return;
            }
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        System.out.printf("Customer %s %s orders a project.\n", customer.getName(), customer.getLastName());

        String customerId = "CL" + (customers.size() + 1);
        customers.put(customerId, customer);
        System.out.printf("Customer %s %s adds to list of company customers.\n", customer.getName(), customer.getLastName());
    }

    @Override
    public void removeCustomer(String customerId) {
        Customer removedCustomer = customers.remove(customerId);
        if (removedCustomer != null) {
            System.out.println("Customer removed: " + customerId);
        } else {
            System.out.println("Customer not found: " + customerId);
        }
    }

    @Override
    public String getCustomerInfo(String customerId) {
        Customer customer = customers.get(customerId);
        System.out.println(customer.toString());
        return customer.toString();
    }

    @Override
    public void sendProgressReport(String customerId) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            System.out.println("Progress report sent to: " + customer.getName());
        } else {
            System.out.println("Customer not found: " + customerId);
        }
    }
}
package com.solvd.buildingcompany.models;

import com.solvd.buildingcompany.models.participants.Customer;
import com.solvd.buildingcompany.models.participants.staff.Employee;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String phoneNumber;
    private List<Project> projects;
    private List<Customer> customers;

    public Company(String name, String phoneNumber, List<Project> projects,
                   List<Customer> customers) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.projects = projects;
        this.customers = customers;
    }

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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addProject(Project project) {
        System.out.printf("Company %s collects information about the project.\n", getName());
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public void addCustomer(Customer customer) {
        System.out.printf("Customer %s %s orders a project.\n", customer.getName(), customer.getLastName());
        customers.add(customer);
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
}
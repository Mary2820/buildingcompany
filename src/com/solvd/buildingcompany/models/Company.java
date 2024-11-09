package com.solvd.buildingcompany.models;

import com.solvd.buildingcompany.models.participants.Customer;
import com.solvd.buildingcompany.models.participants.staff.Employee;

import java.util.ArrayList;

public class Company {
    private String name;
    private String phoneNumber;
    private ArrayList<Project> projects;
    private ArrayList<Customer> customers;

    public Company(String name, String phoneNumber, ArrayList<Project> projects,
                   ArrayList<Customer> customers) {
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

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
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
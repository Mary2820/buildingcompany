package com.solvd.buildingcompany;

public class Customer {
    private String name;
    private int phoneNumber;
    private Project project;
    private Design design;

    public Customer(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        System.out.println("Customer is ordering a project");
        this.project = project;
    }

    public boolean isDesignApproved(Design design) {
        System.out.println("Customer is approving the Design");

        if(design != null) {
            return true;
        } else {
            return false;
        }
    }

}

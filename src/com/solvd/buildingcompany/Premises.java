package com.solvd.buildingcompany;

public abstract class Premises {
    String address;
    int area;

    public Premises(String address, int area) {
        this.address = address;
        this.area = area;
    }
}

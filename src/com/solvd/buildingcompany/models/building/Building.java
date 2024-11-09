package com.solvd.buildingcompany.models.building;

import com.solvd.buildingcompany.models.Project;
import com.solvd.buildingcompany.models.building.components.*;

import java.util.ArrayList;

public class Building {
    private boolean isBuilt;
    private Foundation foundation;
    private Wall[] walls;
    private Roof roof;
    private ArrayList<Door> doors;
    private ArrayList<Window> windows;
    private ElectricalSystem electricalSystem;
    private PlumbingSystem plumbingSystem;
    private GasSystem gasSystem;
    private Project project;

    public Building(Project project) {
        this.project = project;
    }

    public Foundation getFoundation() {
        return foundation;
    }

    public void setFoundation(Foundation foundation) {
        this.foundation = foundation;
    }

    public Wall[] getWalls() {
        return walls;
    }

    public void setWalls(Wall[] walls) {
        this.walls = walls;
    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    public void setDoors(ArrayList<Door> doors) {
        this.doors = doors;
    }

    public ArrayList<Window> getWindows() {
        return windows;
    }

    public void setWindows(ArrayList<Window> windows) {
        this.windows = windows;
    }

    public ElectricalSystem getElectricalSystem() {
        return electricalSystem;
    }

    public void setElectricalSystem(ElectricalSystem electricalSystem) {
        this.electricalSystem = electricalSystem;
    }

    public PlumbingSystem getPlumbingSystem() {
        return plumbingSystem;
    }

    public void setPlumbingSystem(PlumbingSystem plumbingSystem) {
        this.plumbingSystem = plumbingSystem;
    }

    public GasSystem getGasSystem() {
        return gasSystem;
    }

    public void setGasSystem(GasSystem gasSystem) {
        this.gasSystem = gasSystem;
    }

    public boolean isBuilt() {
        return isBuilt;
    }

    public void setIsBuilt(boolean built) {
        isBuilt = built;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
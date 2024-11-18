package com.solvd.buildingcompany.interfaces;

public interface IHandleEmergency {
    void ReportIncident(String incidentDetails);
    void ExecuteEmergencyProtocol();
    String AssessDamage();
}

package com.solvd.buildingcompany.interfaces;

import com.solvd.buildingcompany.models.participants.Customer;

public interface IHandleCustomer {
    void addCustomer(Customer customer);
    void removeCustomer(String customerId);
    String getCustomerInfo(String customerId);
    void sendProgressReport(String customerId);
}

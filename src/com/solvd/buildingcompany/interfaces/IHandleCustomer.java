package com.solvd.buildingcompany.interfaces;

import com.solvd.buildingcompany.exceptions.CustomerNotFoundException;
import com.solvd.buildingcompany.models.participants.Customer;

public interface IHandleCustomer {
    void addCustomer(Customer customer) throws CustomerNotFoundException;
    void removeCustomer(String customerId) throws CustomerNotFoundException;
    String getCustomerInfo(String customerId) throws CustomerNotFoundException;
    void sendProgressReport(String customerId);
}

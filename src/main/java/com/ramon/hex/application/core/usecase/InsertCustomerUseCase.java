package com.ramon.hex.application.core.usecase;

import com.ramon.hex.application.core.domain.Customer;
import com.ramon.hex.application.core.ports.out.FindAddressByZipCodeOutputPort;
import com.ramon.hex.application.core.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerOutputPort {
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort){
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer) {

    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address  = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);

    }
}

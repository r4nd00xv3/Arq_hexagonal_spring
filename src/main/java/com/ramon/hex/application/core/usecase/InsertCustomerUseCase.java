package com.ramon.hex.application.core.usecase;

import com.ramon.hex.adapters.in.out.FindAddressZipCodeAdapterImpl;
import com.ramon.hex.application.core.domain.Customer;
import com.ramon.hex.application.core.ports.in.InsertCustomerInputPort;
import com.ramon.hex.application.core.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressZipCodeAdapterImpl findAddressZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressZipCodeAdapterImpl findAddressZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressZipCodeOutputPort = findAddressZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void inser(Customer customer, String zipCode) {
        var address = findAddressZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}

package com.ramon.hex.application.core.usecase;

import com.ramon.hex.application.core.domain.Customer;
import com.ramon.hex.application.core.ports.in.FindCustomerByIdInputPort;
import com.ramon.hex.application.core.ports.out.FindCustomerByIdOutputPort;


public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));

    }

    public Customer findCustomerById(String id) {
        return null;
    }
}

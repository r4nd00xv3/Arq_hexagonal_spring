package com.ramon.hex.application.core.ports.in;

import com.ramon.hex.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdInputPort {

    Customer findCustomerById(String id);

    Optional<Customer> find(String id);
}

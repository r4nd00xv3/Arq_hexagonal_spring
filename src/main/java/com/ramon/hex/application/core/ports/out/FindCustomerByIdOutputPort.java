package com.ramon.hex.application.core.ports.out;

import com.ramon.hex.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find (String id);
}

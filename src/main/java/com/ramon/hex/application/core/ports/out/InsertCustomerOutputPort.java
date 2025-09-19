package com.ramon.hex.application.core.ports.out;

import com.ramon.hex.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert (Customer customer);

    void insert(Customer customer, String zipCode);
}

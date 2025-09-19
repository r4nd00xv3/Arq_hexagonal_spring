package com.ramon.hex.application.core.ports.in;

import com.ramon.hex.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void inser (Customer customer, String zipCode);
}

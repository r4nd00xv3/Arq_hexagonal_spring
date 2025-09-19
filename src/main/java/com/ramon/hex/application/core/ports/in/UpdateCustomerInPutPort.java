package com.ramon.hex.application.core.ports.in;

import com.ramon.hex.application.core.domain.Customer;

public interface UpdateCustomerInPutPort {
    void updateCustomerInPut(Customer customer, String zipCode);

    void update(Customer customer, String zipCode);
}

package com.ramon.hex.application.core.ports.in;

import com.ramon.hex.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}

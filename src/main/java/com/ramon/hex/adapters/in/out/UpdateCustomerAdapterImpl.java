package com.ramon.hex.adapters.in.out;

import com.ramon.hex.adapters.in.controller.response.CustomerResponse;
import com.ramon.hex.adapters.in.out.repository.CustomerRepository;
import com.ramon.hex.adapters.in.out.repository.mapper.CustomerEntityMapper;
import com.ramon.hex.application.core.domain.Customer;
import com.ramon.hex.application.core.ports.out.UpdateCustomerOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapterImpl implements UpdateCustomerOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;


    @Override
    public void updateCustomerOutPut(Customer customer) {
        var customerEntity = customerEntityMapper.toCostumer(customer);
        customerRepository.save(customerEntity);


    }
}

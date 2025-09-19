package com.ramon.hex.adapters.in.out;

import com.ramon.hex.adapters.in.out.repository.CustomerRepository;
import com.ramon.hex.adapters.in.out.repository.mapper.CustomerEntityMapper;
import com.ramon.hex.application.core.domain.Customer;
import com.ramon.hex.application.core.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;



    public void insert (Customer customer){

        var customerEntity = customerEntityMapper.toCostumer(customer);
        customerRepository.save(customerEntity);
    }
}

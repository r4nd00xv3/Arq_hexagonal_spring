package com.ramon.hex.adapters.in.out;

import com.ramon.hex.adapters.in.out.repository.CustomerRepository;
import com.ramon.hex.adapters.in.out.repository.mapper.CustomerEntityMapper;
import com.ramon.hex.application.core.domain.Customer;

import com.ramon.hex.application.core.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapterImpl implements FindCustomerByIdOutputPort {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {

        var customer = customerRepository.findById(id);

        return customer.map(entity -> customerEntityMapper.toCustomer(entity));

    }
}

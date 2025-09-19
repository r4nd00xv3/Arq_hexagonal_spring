package com.ramon.hex.adapters.in.out;

import com.ramon.hex.adapters.in.out.repository.CustomerRepository;
import com.ramon.hex.application.core.ports.out.DeleteCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public  class DeleteCostumerByIdAdapterImpl implements DeleteCustomerByIdOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);

    }
}

package com.ramon.hex.adapters.in.controller;

import com.ramon.hex.adapters.in.controller.mapper.CustomerMapper;
import com.ramon.hex.adapters.in.controller.request.CustomerRequest;
import com.ramon.hex.application.core.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.inser(customer, customerRequest.getZipCode());
        return  ResponseEntity.ok().build();
    }

}

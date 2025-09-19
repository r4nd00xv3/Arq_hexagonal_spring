package com.ramon.hex.adapters.in.controller;

import com.ramon.hex.adapters.in.controller.mapper.CustomerMapper;
import com.ramon.hex.adapters.in.controller.request.CustomerRequest;
import com.ramon.hex.adapters.in.controller.response.CustomerResponse;
import com.ramon.hex.application.core.domain.Customer;
import com.ramon.hex.application.core.ports.in.DeleteCustomerByIdInputPort;
import com.ramon.hex.application.core.ports.in.FindCustomerByIdInputPort;
import com.ramon.hex.application.core.ports.in.InsertCustomerInputPort;
import com.ramon.hex.application.core.ports.in.UpdateCustomerInPutPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInPutPort updateCustomerInPutPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;



    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.inser(customer, customerRequest.getZipCode());
        return  ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> get(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {

        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInPutPort.updateCustomerInPut(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        return ResponseEntity.noContent().build();
    }
}

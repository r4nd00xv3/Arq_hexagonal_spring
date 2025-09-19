package com.ramon.hex.application.core.usecase;

import com.ramon.hex.application.core.domain.Customer;
import com.ramon.hex.application.core.ports.in.FindCustomerByIdInputPort;
import com.ramon.hex.application.core.ports.in.UpdateCustomerInPutPort;
import com.ramon.hex.application.core.ports.out.FindAddressByZipCodeOutputPort;
import com.ramon.hex.application.core.ports.out.UpdateCustomerOutPutPort;

public abstract class UpdateCustomerUseCase implements UpdateCustomerInPutPort {


    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, com.ramon.hex.application.core.ports.out.UpdateCustomerOutPutPort updateCustomerOutPutPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutPutPort = updateCustomerOutPutPort;
    }

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdateCustomerOutPutPort updateCustomerOutPutPort;



    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutPutPort.updateCustomerOutPut(customer);

    }

}

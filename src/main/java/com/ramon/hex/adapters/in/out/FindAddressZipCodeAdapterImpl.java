package com.ramon.hex.adapters.in.out;

import com.ramon.hex.adapters.in.out.client.FindAddressByZipCodeClient;
import com.ramon.hex.adapters.in.out.client.mapper.AddressResponseMapper;
import com.ramon.hex.adapters.in.out.client.response.AddressResponse;
import com.ramon.hex.application.core.domain.Address;
import com.ramon.hex.application.core.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressZipCodeAdapterImpl implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}

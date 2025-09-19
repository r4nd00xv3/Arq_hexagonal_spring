package com.ramon.hex.adapters.in.out.client.mapper;


import com.ramon.hex.adapters.in.out.client.response.AddressResponse;
import com.ramon.hex.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}

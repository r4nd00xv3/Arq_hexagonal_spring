package com.ramon.hex.adapters.in.out.repository.mapper;

import com.ramon.hex.adapters.in.out.repository.entity.CustomerEntity;
import com.ramon.hex.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

CustomerEntity toCostumer (Customer customer);

}








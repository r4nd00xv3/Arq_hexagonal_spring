package com.ramon.hex.config;

import com.ramon.hex.adapters.in.out.FindAddressZipCodeAdapterImpl;
import com.ramon.hex.adapters.in.out.FindCustomerByIdAdapterImpl;
import com.ramon.hex.adapters.in.out.InsertCustomerAdapterImpl;
import com.ramon.hex.adapters.in.out.UpdateCustomerAdapterImpl;
import com.ramon.hex.application.core.domain.Customer;
import com.ramon.hex.application.core.ports.in.FindCustomerByIdInputPort;
import com.ramon.hex.application.core.usecase.FindCustomerByIdUseCase;
import com.ramon.hex.application.core.usecase.InsertCustomerUseCase;
import com.ramon.hex.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(


            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressZipCodeAdapterImpl findAddressZipCodeAdap,
            UpdateCustomerAdapterImpl updateCustomerAdapter
    ){
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressZipCodeAdap, updateCustomerAdapter) {
            @Override
            public void updateCustomerInPut(Customer customer, String zipCode) {

            }
        };
    }
}

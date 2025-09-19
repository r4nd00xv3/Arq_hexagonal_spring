package com.ramon.hex.config;

import com.ramon.hex.adapters.in.out.FindCustomerByIdAdapterImpl;
import com.ramon.hex.adapters.in.out.InsertCustomerAdapterImpl;
import com.ramon.hex.application.core.domain.Customer;
import com.ramon.hex.application.core.ports.in.FindCustomerByIdInputPort;
import com.ramon.hex.application.core.usecase.FindCustomerByIdUseCase;
import com.ramon.hex.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(


            FindCustomerByIdAdapterImpl findCustomerByIdAdapter
    ){
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter) {
            @Override
            public Customer findCustomerById(String id) {
                return null;
            }
        };
    }
}

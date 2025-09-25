package com.ramon.hex.config;

import com.ramon.hex.adapters.in.out.FindCustomerByIdAdapterImpl;
import com.ramon.hex.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(


            FindCustomerByIdAdapterImpl findCustomerByIdAdapter
    ){
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter) {
        };
    }
}

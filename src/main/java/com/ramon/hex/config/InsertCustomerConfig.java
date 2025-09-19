package com.ramon.hex.config;

import com.ramon.hex.adapters.in.out.FindAddressZipCodeAdapterImpl;
import com.ramon.hex.adapters.in.out.InsertCustomerAdapterImpl;
import com.ramon.hex.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(


            FindAddressZipCodeAdapterImpl findAddressZipCodeAdap,
            InsertCustomerAdapterImpl insertCustomerAdapter
    ){
        return new InsertCustomerUseCase(findAddressZipCodeAdap, insertCustomerAdapter);
    }
}

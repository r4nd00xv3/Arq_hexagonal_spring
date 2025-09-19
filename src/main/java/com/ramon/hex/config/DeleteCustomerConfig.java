package com.ramon.hex.config;

import com.ramon.hex.adapters.in.out.DeleteCostumerByIdAdapterImpl;
import com.ramon.hex.adapters.in.out.FindAddressZipCodeAdapterImpl;
import com.ramon.hex.adapters.in.out.UpdateCustomerAdapterImpl;
import com.ramon.hex.application.core.domain.Customer;
import com.ramon.hex.application.core.usecase.DeleteCustomerByIdUseCase;
import com.ramon.hex.application.core.usecase.FindCustomerByIdUseCase;
import com.ramon.hex.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(


            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCostumerByIdAdapterImpl deleteCostumerByIdAdapterImpl
    ){
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCostumerByIdAdapterImpl) {

        };
    }
}

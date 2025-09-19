package com.ramon.hex.adapters.in.controller.response;

import com.ramon.hex.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;

}

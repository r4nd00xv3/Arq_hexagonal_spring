package com.ramon.hex.adapters.in.consumer;

import com.ramon.hex.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.ramon.hex.adapters.in.consumer.message.CustomerMessage;
import com.ramon.hex.application.core.ports.in.UpdateCustomerInPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInPutPort updateCustomerInPutPort;

    @Autowired
    private CustomerMessageMapper CustomerMessageMapper;
    @Autowired
    private CustomerMessageMapper customerMessageMapper;


    @KafkaListener(topics = "tp-cpf-validated", groupId = "arantes")
    public void receiveValidatedCpf(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInPutPort.update(customer, customerMessage.getZipCode());
    }


}

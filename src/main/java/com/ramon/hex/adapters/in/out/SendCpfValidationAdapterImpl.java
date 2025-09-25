package com.ramon.hex.adapters.in.out;

import com.ramon.hex.application.core.ports.out.SendCpfForValidationOutputPort;
import com.ramon.hex.config.KafkaConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapterImpl implements SendCpfForValidationOutputPort {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);

    }
}

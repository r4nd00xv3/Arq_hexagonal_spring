package com.ramon.hex.application.core.ports.out;

import com.ramon.hex.application.core.domain.Address;
import org.apache.kafka.common.protocol.types.Field;

public interface FindAddressByZipCodeOutputPort {
    Address find (String zipCode);
}

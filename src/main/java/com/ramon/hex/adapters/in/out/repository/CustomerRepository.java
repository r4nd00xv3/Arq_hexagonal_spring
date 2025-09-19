package com.ramon.hex.adapters.in.out.repository;

import com.ramon.hex.adapters.in.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}

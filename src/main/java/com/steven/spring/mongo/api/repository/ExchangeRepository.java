package com.steven.spring.mongo.api.repository;

import com.steven.spring.mongo.api.model.Exchange;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExchangeRepository extends MongoRepository<Exchange, Integer> {
}

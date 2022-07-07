package com.steven.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.steven.spring.mongo.api.model.Writer;

public interface WriterRepository extends MongoRepository<Writer, Integer> {

}

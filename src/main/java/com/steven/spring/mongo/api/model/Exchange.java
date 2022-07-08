package com.steven.spring.mongo.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.HashMap;

@Getter
@Setter
@ToString

@Document(collection = "Exchange")
public class Exchange {
    private String country;
    private Timestamp last_updated;
    private HashMap<String, Float> currency = new HashMap<>();
}

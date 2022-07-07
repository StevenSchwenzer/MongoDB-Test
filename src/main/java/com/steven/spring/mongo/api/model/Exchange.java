package com.steven.spring.mongo.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.sql.Timestamp;

@Getter
@Setter
@ToString

@Document(collection = "Exchange")
public class Exchange {
    @Id
    private int id;
    private String country;
    private Timestamp last_updated;
    private HashMap<String, Float> currency = new HashMap<>();
}

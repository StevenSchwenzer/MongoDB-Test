package com.steven.spring.mongo.api.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Writer")
public class Writer {
        @Id
        private int id;
        private String name;
        private String lastName;
        private List<Book> writtenBooks;
}

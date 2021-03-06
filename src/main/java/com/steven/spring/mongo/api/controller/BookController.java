package com.steven.spring.mongo.api.controller;

import com.steven.spring.mongo.api.model.Book;
import com.steven.spring.mongo.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class BookController {
        
        @Autowired
        private BookRepository repository;

        @PostMapping("/addBook")
        public String saveBook(@RequestBody Book book) {
                repository.save(book);
                return "Added Book with ID : " + book.getId();
        }

        @GetMapping("/findAllBooks")
        public List<Book> getBooks() {
                return repository.findAll();
        }

        @GetMapping("/findAllBooks/{id}")
        public Optional<Book> getBook(@PathVariable int id) {
                return repository.findById(id);
        }

        @DeleteMapping("/deleteBook/{id}")
        public String deleteBook(@PathVariable int id) {
                repository.deleteById(id);
                return "Deleted Book with ID : " + id;
        }

}

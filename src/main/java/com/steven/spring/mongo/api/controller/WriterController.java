package com.steven.spring.mongo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.steven.spring.mongo.api.model.Writer;
import com.steven.spring.mongo.api.repository.WriterRepository;

@RequestMapping("/api")
@RestController
public class WriterController {

        @Autowired
        private WriterRepository repository;

        @PostMapping("/addWriter")
        public String saveWriter(@RequestBody Writer writer){
                repository.save(writer);
                return "Added Writer with ID : " + writer.getId();
        }

        @GetMapping("/findAllWriter")
        public List<Writer> getWriter() {
                return repository.findAll();
        }

        @GetMapping("/findAllWriter/{id}")
        public Optional<Writer> getWriter(@PathVariable int id){
                return repository.findById(id);
        }

        @DeleteMapping("/deleteWriter/{id}")
        public String deleteWriter(@PathVariable int id){
                repository.deleteById(id);
                return "Deleted Writer with ID : " + id;
        }
        
}

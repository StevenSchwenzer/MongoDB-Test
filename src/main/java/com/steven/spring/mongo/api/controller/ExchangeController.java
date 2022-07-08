package com.steven.spring.mongo.api.controller;

import com.steven.spring.mongo.api.client.CurrencyClientAPI;
import com.steven.spring.mongo.api.model.Exchange;
import com.steven.spring.mongo.api.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ExchangeController {

        @Autowired
        private ExchangeRepository repository;

        @Autowired
        private CurrencyClientAPI currencyClientAPI;

        @PostMapping("/addExchange")
        public String saveExchange(@RequestBody Exchange exchange) {
                repository.save(exchange);
                return "Added Exchange for ID: ";
        }

        @GetMapping("/findAllExchanges")
        public List<Exchange> getExchanges(){
                return repository.findAll();
        }

        @GetMapping("/findAllExchanges/{id}")
        public Optional<Exchange> getExchangeById(@PathVariable int id) {
                return repository.findById(id);
        }

        @DeleteMapping("/deleteExchange/{id}")
        public String deleteExchange(@PathVariable int id) {
                repository.deleteById(id);
                return "Deleted Exchange with ID : " + id;
        }

        @GetMapping("/getLiveCurrency")
        public Exchange getLiveCurrency() {
                //CurrencyClientAPI currencyClientAPI = new CurrencyClientAPI();
                return currencyClientAPI.sendRestCall();
        }
}


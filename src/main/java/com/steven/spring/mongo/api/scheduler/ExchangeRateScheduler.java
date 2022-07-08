package com.steven.spring.mongo.api.scheduler;

import com.steven.spring.mongo.api.client.CurrencyClientAPI;
import com.steven.spring.mongo.api.model.Exchange;
import com.steven.spring.mongo.api.repository.ExchangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExchangeRateScheduler {

        @Autowired
        private ExchangeRepository exchangeRepository;

        @Autowired
        private CurrencyClientAPI currencyClientAPI;

        @Scheduled(cron = "0 0/1 * * * ?")
        public void ExchangeScheduler(){
                Exchange currentExchange = currencyClientAPI.sendRestCall();
                log.info("Current Exchange: "+ currentExchange);
                exchangeRepository.save(currentExchange);
        }
}

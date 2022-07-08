package com.steven.spring.mongo.api.client;


import com.steven.spring.mongo.api.model.Exchange;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyClientAPI {
        public Exchange sendRestCall(){
                RestTemplate restTemplate = new RestTemplate();
                String exchangeUrl
                        = "https://flexie.io/currency";
                Exchange exchange = restTemplate
                        .getForObject(exchangeUrl, Exchange.class);
                System.out.println(exchange);
                return exchange;
        }
}

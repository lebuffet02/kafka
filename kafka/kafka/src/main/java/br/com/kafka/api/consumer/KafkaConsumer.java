package br.com.kafka.api.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "ecommerce.cliente2", groupId = "ecommerce-groupId") //topico a ser consumido e o seu grupo id
    public void consumer(String message) {
        System.out.println(message);
    }
}

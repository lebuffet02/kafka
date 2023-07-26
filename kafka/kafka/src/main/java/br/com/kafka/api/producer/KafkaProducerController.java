package br.com.kafka.api.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/producer/{message}")
    public void producer(
            @PathVariable(name = "message") String message) {
        this.kafkaTemplate.send("ecommerce.cliente2", message); //enviar a mensagem para o topico
    }
}

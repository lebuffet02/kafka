package br.com.kafka.api.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var producer = new KafkaProducer<String, String>(properties());

        Callback callback = (data, e) -> {
            if (e != null) {
                e.printStackTrace();
                return;
            }
            System.out.println("mensagem publicada com sucesso: ");
            System.out.println(data.partition());
            System.out.println(data.offset());
        };

        for (int i = 0; i < 10; i++) {
            var record = new ProducerRecord<>("ecommerce.compras", "cliente " + i,"compras: " + i + " reais");
            producer.send(record, callback).get();
        }
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092"); // onde o kafka está rodando
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }
}

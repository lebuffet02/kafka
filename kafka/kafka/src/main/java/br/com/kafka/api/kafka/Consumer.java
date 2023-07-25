package br.com.kafka.api.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Consumer {

    public static void main(String[] args) {

        var consumer = new KafkaConsumer<String, String>(properties());
        consumer.subscribe(Collections.singletonList("compras.do.cliente"));

        while (true) {
            var records = consumer.poll(Duration.ofMillis(100));
            for (var r : records) {
                System.out.println("Compra nova: ");
                System.out.println(r.key());
                System.out.println(r.value());
                System.out.println(r.offset());
                System.out.println(r.partition());
            }
//            records.forEach(r -> {
//                System.out.println("Compra nova: ");
//                System.out.println(r.key());
//                System.out.println(r.value());
//                System.out.println(r.offset());
//                System.out.println(r.partition());
//            });
        }
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092"); // onde o kafka está rodando
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "consumo-cliente");
        return properties;
    }

}

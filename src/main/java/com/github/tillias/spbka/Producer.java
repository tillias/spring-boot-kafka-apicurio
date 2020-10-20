package com.github.tillias.spbka;

import com.github.tillias.spbka.schema.avro.Event;
import com.github.tillias.spbka.utils.Topic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate<String, Event> kafkaTemplate;

    public void send(Event payload) {
        log.info("Producer sending message {} to topic {}", payload, Topic.NAME);
        this.kafkaTemplate.send(Topic.NAME, payload);
    }
}
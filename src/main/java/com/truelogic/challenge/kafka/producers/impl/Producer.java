package com.truelogic.challenge.kafka.producers.impl;

import com.truelogic.challenge.kafka.producers.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer implements ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message, String topicName) {
        log.info(String.format("#### -> Producing message -> %s", message));
        kafkaTemplate.send(topicName, message);
    }

}
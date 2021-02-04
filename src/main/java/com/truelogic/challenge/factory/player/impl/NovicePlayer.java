package com.truelogic.challenge.factory.player.impl;

import com.truelogic.challenge.domain.request.PlayerInput;
import com.truelogic.challenge.factory.player.PlayerTypeProcess;
import com.truelogic.challenge.kafka.producers.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Novice Player Class
 */
@Component
public class NovicePlayer extends PlayerTypeProcess {

    @Value("${message.topic.name}")
    private String topic;

    @Autowired
    ProducerService producer;

    @Override
    public void process(PlayerInput player) {
        producer.sendMessage(player.toString(),topic);
    }

    @Override
    public String actionProcess(String name) {
        return String.format("Player %s sent to Kafka topic",name);
    }
}

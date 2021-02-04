package com.truelogic.challenge.kafka;

import com.truelogic.challenge.kafka.producers.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class producerTest {

    @Autowired
    ProducerService producer;

    @Value("${test.topic}")
    private String topic;

    @Test
    public void whenReceiveValidMessageAndTopicThenSendMessageToConsumer() throws InterruptedException {
        // To-do : implement integration test for send message to consumer
    }

}

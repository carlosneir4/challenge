package com.truelogic.challenge.kafka.producers;

/**
 * Interface Producer Service
 */
public interface ProducerService {

    /**
     * Method to send a message to a kafka topic
     * @param message
     * @param topicName
     */
    void sendMessage(String message,String topicName);
}

package com.eventdriver.publisher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventdriver.publisher.dto.RequestPublishMessage;
import com.eventdriver.publisher.queueBroker.publisher.MessageBrokerPublisher;

@Service
public class PublishService {

    @Autowired
    private MessageBrokerPublisher queueMessagePublisher;


    public boolean publishMessage (RequestPublishMessage params) {
        queueMessagePublisher.sendMessage(params);
        return true;
    }

}

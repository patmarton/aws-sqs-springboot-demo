package com.example.sqs.awssqsspringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties
public class basicResource {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    Logger logger = LoggerFactory.getLogger(basicResource.class);

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    //Sending messgae to queue
    @GetMapping("/send/{message}")
    public void sendMessage(@PathVariable String message){
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());

    }

    @SqsListener("SimpleQueue")
    public void loadMessageFromSqs(String message){
        logger.info(message);

    }

}

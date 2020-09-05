package com.example.sqs.awssqsspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude= {ContextStackAutoConfiguration.class})
public class AwsSqsSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsSqsSpringbootApplication.class, args);
    }
}



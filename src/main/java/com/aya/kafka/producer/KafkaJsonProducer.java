package com.aya.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.aya.kafka.payload.Student;

import lombok.RequiredArgsConstructor;

@Service // or @Component
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendMessage(Student student) {
        System.out.println("I am in the SendMessage Json before");
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "alibou")
                .build();

        System.out.println("I am in the SendMessage Json after");
        kafkaTemplate.send(message);
        System.out.println("I am after kafka template");


//        Message<Student> message = MessageBuilder
//                .withPayload(student)
//                .setHeader(KafkaHeaders.TOPIC, "aya")
//                .build();
//
//        kafkaTemplate.send(message);

    }
}

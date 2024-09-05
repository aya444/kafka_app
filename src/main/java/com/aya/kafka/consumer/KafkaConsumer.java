package com.aya.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.aya.kafka.payload.Student;

import lombok.extern.slf4j.Slf4j;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "aya", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info(format("Consuming the message from aya Topic:: %s", msg));
    }

    @KafkaListener(topics = "aya", groupId = "myGroup")
    public void consumeJsonMsg(Student student) {
        log.info(format("Consuming the message from aya Topic:: %s", student.toString()));
    }

}

package com.aya.kafka.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aya.kafka.payload.Student;
import com.aya.kafka.producer.KafkaJsonProducer;
import com.aya.kafka.producer.KafkaProducer;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

     @PostMapping("/string")
     public ResponseEntity<String> sendMessage(@RequestBody String message) {
         kafkaProducer.sendMessage(message);
         return ResponseEntity.ok("Message queued successfuly!");
     }

    @PostMapping("/student")
    public ResponseEntity<String> sendMessage(@RequestBody Student student) {
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Message queued successfuly as JSON!");
    }

}

 package com.aya.kafka.producer;

 import org.springframework.kafka.core.KafkaTemplate;
 import org.springframework.stereotype.Service;

 import lombok.RequiredArgsConstructor;
 import lombok.extern.slf4j.Slf4j;

 import static java.lang.String.format;

 @Service // or @Component
 @RequiredArgsConstructor
 @Slf4j // for logging
 public class KafkaProducer {

     private final KafkaTemplate<String, String> kafkaTemplate;

     public void sendMessage(String msg) {
         log.info(format("Sending message to aya Topic:: %s", msg));
         kafkaTemplate.send("aya", msg);
     }
 }
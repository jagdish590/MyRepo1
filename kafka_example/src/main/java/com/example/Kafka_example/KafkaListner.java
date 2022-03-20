package com.example.Kafka_example;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListner {
	@KafkaListener(topics = "myfirsttopic", groupId="groupId")
	void listner(String data) {
		System.out.println("Received data :" + data);
		
	}

}

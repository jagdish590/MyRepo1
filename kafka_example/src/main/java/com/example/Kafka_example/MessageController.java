package com.example.Kafka_example;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messeges")
public class MessageController {
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate= kafkaTemplate;
		
	}

	@PostMapping (consumes = {MediaType.APPLICATION_XML_VALUE, 
            MediaType.APPLICATION_JSON_VALUE},
  produces = {MediaType.APPLICATION_XML_VALUE, 
	          MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RequestMessage> publish(@RequestBody RequestMessage requestMessage) {
		String message = requestMessage.getMessage();
		kafkaTemplate.send("myfirsttopic", message);
		
		return new ResponseEntity<>(requestMessage,HttpStatus.OK);
	}
}

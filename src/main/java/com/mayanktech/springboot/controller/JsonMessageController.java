package com.mayanktech.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayanktech.springboot.kafka.JsonKafkaProducer;
import com.mayanktech.springboot.model.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageController.class);
	
	private JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user){
		LOGGER.info("Inside publish method");
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message sent to kafka topic");
	}
	
}

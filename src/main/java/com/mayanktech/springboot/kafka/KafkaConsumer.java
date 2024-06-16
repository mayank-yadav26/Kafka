package com.mayanktech.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mayanktech.springboot.model.User;

@Service
public class KafkaConsumer {
	private static final Logger LOGGER  = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics="mayankTech", groupId="myGroup")
	public void consume(String message) {
		LOGGER.info(String.format("Message received %s", message));
	}
	
	@KafkaListener(topics="mayankTech_json", groupId="myGroup")
	public void consumeJson(User user) {
		LOGGER.info(String.format("Message received %s", user.toString()));
	}
}

package com.mayanktech.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic myTopic() {
		return TopicBuilder.name("mayankTech")
				.partitions(1)
                .replicas(1)
				.build();
	}

}

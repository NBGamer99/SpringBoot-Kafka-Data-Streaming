package me.ynabouzi.springbootkafka.kafka.Producers;

import me.ynabouzi.springbootkafka.payload.User;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer
{
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JsonKafkaProducer.class);

	private final KafkaTemplate<String, User> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(User user) {

		Message<User> message = MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC, "topic2")
				.build();

		LOGGER.info(String.format("#### -> Produced JSON -> %s", user));
		kafkaTemplate.send(message);
	}

}



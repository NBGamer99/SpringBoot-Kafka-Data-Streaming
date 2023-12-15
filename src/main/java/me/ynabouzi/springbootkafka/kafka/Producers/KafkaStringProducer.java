package me.ynabouzi.springbootkafka.kafka.Producers;

import org.slf4j.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaStringProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaStringProducer.class);
	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaStringProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		LOGGER.info(String.format("#### -> Produced message -> %s", message));
		kafkaTemplate.send("topic1", message);
	}
}

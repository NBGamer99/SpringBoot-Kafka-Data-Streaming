package me.ynabouzi.springbootkafka.kafka;

import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer
{
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "topic1", groupId = "group1")
	public void consume(String message)
	{
		LOGGER.info(String.format("#### -> Consumed message -> %s", message));
	}
}

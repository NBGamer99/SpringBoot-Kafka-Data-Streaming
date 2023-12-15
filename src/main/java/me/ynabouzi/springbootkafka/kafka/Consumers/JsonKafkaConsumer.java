package me.ynabouzi.springbootkafka.kafka.Consumers;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import me.ynabouzi.springbootkafka.payload.User;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class JsonKafkaConsumer {
		private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JsonKafkaConsumer.class);

		@KafkaListener(topics = "topic2", groupId = "group1")
		public void consume(User user)
		{
			LOGGER.info(String.format("#### -> Consumed JSON  -> %s", user));
		}
}

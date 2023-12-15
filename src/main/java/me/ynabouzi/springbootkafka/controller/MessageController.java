package me.ynabouzi.springbootkafka.controller;

import me.ynabouzi.springbootkafka.kafka.Producers.KafkaStringProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

	private final KafkaStringProducer kafkaStringProducer;

	public MessageController(KafkaStringProducer kafkaStringProducer) {
		this.kafkaStringProducer = kafkaStringProducer;
	}

	// http://localhost:8080/api/v1/kafka/publish?message=HelloWorld

	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message) {
		if (message == null || message.isEmpty()) {
			return ResponseEntity.badRequest().body("Message cannot be empty");
		}
		kafkaStringProducer.sendMessage(message);
		return ResponseEntity.ok(message);
	}

}

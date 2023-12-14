package me.ynabouzi.springbootkafka.controller;

import me.ynabouzi.springbootkafka.kafka.KafkaProducer;
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

	private final KafkaProducer kafkaProducer;

	public MessageController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	// http://localhost:8080/api/v1/kafka/publish?message=HelloWorld

	@GetMapping("/publish")
	public ResponseEntity<Map<String, Object>> publish(@RequestParam("message") String message) {
		Map<String, Object> response = new HashMap<>();
		if (message == null || message.isEmpty()) {
			response.put("statusCode", HttpStatus.BAD_REQUEST.value());
			response.put("message", "Message cannot be empty");
			return ResponseEntity.badRequest().body(response);
		}
		kafkaProducer.sendMessage(message);
		response.put("statusCode", HttpStatus.OK.value());
		response.put("message", message);
		return ResponseEntity.ok(response);
	}

}

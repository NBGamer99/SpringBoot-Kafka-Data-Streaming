package me.ynabouzi.springbootkafka.controller;

import me.ynabouzi.springbootkafka.kafka.Producers.JsonKafkaProducer;
import me.ynabouzi.springbootkafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	private final JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
		this.jsonKafkaProducer = jsonKafkaProducer;
	}

	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user) {
		if (user == null) {
			return ResponseEntity.badRequest().body("User cannot be empty");
		}
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("JSON Message published");
	}


}

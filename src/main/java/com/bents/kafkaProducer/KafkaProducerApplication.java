package com.bents.kafkaProducer;

import com.bents.kafkaProducer.constants.IKafkaConstants;
import com.bents.kafkaProducer.dto.KafkaMessageDTO;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static SecureRandom rnd = new SecureRandom();

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		KafkaMessageDTO kafkaMessageDTO = new KafkaMessageDTO();
		kafkaMessageDTO.setMessage(getRandomString(16));
		ProducerRecord<Long, KafkaMessageDTO> record = new ProducerRecord<>(IKafkaConstants.TOPIC_NAME, kafkaMessageDTO);
	}

	private String getRandomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for(int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}
}

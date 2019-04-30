package com.bents.kafkaProducer.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class KafkaMessageDTO implements Serializable {
    private Long index;
    private String message;
}
